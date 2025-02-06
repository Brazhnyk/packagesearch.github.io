package com.peakwork.trainee.artem.packagesearch;

import com.peakwork.trainee.artem.packagesearch.models.Flight;
import com.peakwork.trainee.artem.packagesearch.models.Hotel;
import com.peakwork.trainee.artem.packagesearch.repo.BrabookingRepositoryFlight;
import com.peakwork.trainee.artem.packagesearch.repo.BrabookingRepositoryHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@CrossOrigin
@RestController
@Component
public class MyFirstProjectController {

    private final BrabookingRepositoryHotel brabookingRepositoryHotel;
    private final BrabookingRepositoryFlight brabookingRepositoryFlight;

    public MyFirstProjectController(BrabookingRepositoryHotel brabookingRepositoryHotel, BrabookingRepositoryFlight brabookingRepositoryFlight) {
        this.brabookingRepositoryHotel = brabookingRepositoryHotel;
        this.brabookingRepositoryFlight = brabookingRepositoryFlight;
    }


    @Autowired
    private HotelInfoSource hotelInfoSource;

    @GetMapping("/hotels")
    public ArrayList<Hotel> scanHotelsDatabase() throws IOException {
        List<Hotel> hotels = this.brabookingRepositoryHotel.findAll();
        ArrayList<Hotel> hotel = new ArrayList<>();
        hotel.addAll(hotels);
        return hotel;
    }

    @GetMapping("/flights")
    public ArrayList<Flight> scanFlightsCsvFile() throws IOException {
        return giveDataBaseFlights();
    }

    @GetMapping("/packages")
    public ArrayList<Travel> giveTravelsList(@RequestParam(value = "arrival", required = false) String inputIATA) throws
            IOException {
        try {
            if (inputIATA.length() != 3) {
                throw new RuntimeException("Must be three Letters");
            }

            inputIATA = inputIATA.toUpperCase();

            ArrayList<Hotel> hotelsList = giveDatabaseHotels();
            ArrayList<Flight> flightsList = giveDataBaseFlights();

            if (giveTravelsListViaIATA(hotelsList, flightsList, inputIATA).isEmpty()) {
                throw new RuntimeException("I don´t have the information for this airport");
            } else
                return giveTravelsListViaIATA(hotelsList, flightsList, inputIATA);

        } catch (IOException ioe) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ioe.getMessage());
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage());
        }
    }

    @GetMapping("/offers")
    public ArrayList<Offer> givePersonNightCoastViaIATA(@RequestParam(value = "arrival", required = false) String
                                                                codeIATA,
                                                        @RequestParam(value = "persons", required = false) String persons,
                                                        @RequestParam(value = "los", required = false) String nights) {

        try {

            if (nights.equals("")) throw new NumberFormatException("Nights can´t be empty, please enter data");
            if (persons.equals("")) throw new NumberFormatException("Persons can´t be empty, please enter data");

            if (Integer.parseInt(persons) < 1) {
                throw new RuntimeException("One or more person must travel");
            }
            if (Integer.parseInt(nights) < 1) {
                throw new RuntimeException("Must be at least one night");
            }
            if (codeIATA.length() != 3) {
                throw new RuntimeException("Must be three Letters");
            }

            codeIATA = codeIATA.toUpperCase();

            ArrayList<Hotel> hotelsList = giveDatabaseHotels();
            ArrayList<Flight> flightsList = giveDataBaseFlights();
            ArrayList<Offer> offersList = giveTotalOffersCoast(hotelsList, flightsList, Integer.parseInt(persons), Integer.parseInt(nights), codeIATA);

            if (giveTotalOffersCoast(hotelsList, flightsList, Integer.parseInt(persons), Integer.parseInt(nights), codeIATA).isEmpty()) {
                throw new RuntimeException("I don´t have the information for this airport");
            } else
                return offersList;

        } catch (IOException ioe) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ioe.getMessage());
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage());
        }
    }

    public ArrayList<Hotel> giveDatabaseHotels() {
        ArrayList<Hotel> hotels = new ArrayList<>();
        List<Hotel> hotelsList = this.brabookingRepositoryHotel.findAll();
        hotels.addAll(hotelsList);

        return hotels;
    }

    public ArrayList<Flight> giveDataBaseFlights() throws IOException {
        ArrayList<Flight> flights = new ArrayList<>();
        List<Flight> flightsList = this.brabookingRepositoryFlight.findAll();
        try {
            flights.addAll(flightsList);
        } catch (Exception ex) {

            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return flights;
    }

    public ArrayList<Travel> giveTravelsListViaIATA(ArrayList<Hotel> hotelsList, ArrayList<Flight> flightsList, String inputIATA) {
        ArrayList<Travel> travels = new ArrayList<>();
        int count = 1;
        for (Flight flight : flightsList) {
            for (Hotel hotel : hotelsList) {
                if (flight.getArrivalAirport().contains(hotel.getNextHotelAirport())
                        && flight.getArrivalAirport().contains(inputIATA)) {
                    travels.add(new Travel(
                            count,
                            flight.getFlightProvider(),
                            flight.getDepartureAirport(),
                            flight.getArrivalAirport(),
                            hotel.getHotelName(),
                            flight.getPrice(),
                            hotel.getPrice()));
                    count++;
                }
            }
        }
        return travels;
    }


    public ArrayList<Offer> giveTotalOffersCoast(ArrayList<Hotel> hotelsList, ArrayList<Flight> flightsList, int persons, int nights, String inputIATA) {
        ArrayList<Offer> offerCosts = new ArrayList<>();

        int count = 1;
        for (Flight flight : flightsList) {
            for (Hotel hotel : hotelsList) {
                if (flight.getArrivalAirport().equalsIgnoreCase(hotel.getNextHotelAirport())) {
                    if (flight.getArrivalAirport().equals(inputIATA)) {
                        List<HotelInfo> hotelInfo = hotelInfoSource.getQueryHotelInfoViaURL(hotel.getId());
                        offerCosts.add(new Offer(
                                count,
                                flight.getFlightProvider(),
                                flight.getDepartureAirport(),
                                flight.getArrivalAirport(), hotelInfo.get(0),
                                flight.getPrice() * persons,
                                hotel.getPrice() * nights * persons, flight.getPrice() * persons + hotel.getPrice() * nights * persons
                        ));
                        count++;
                    }
                }
            }
        }
        offerCosts.sort(Comparator.comparingDouble(Offer::getTotalPrice));
        return offerCosts;
    }
}
