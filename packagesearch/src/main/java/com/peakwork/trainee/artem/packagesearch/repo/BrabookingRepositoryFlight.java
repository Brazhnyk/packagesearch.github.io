package com.peakwork.trainee.artem.packagesearch.repo;

import com.peakwork.trainee.artem.packagesearch.models.Flight;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface BrabookingRepositoryFlight extends MongoRepository<Flight, String>  {
}
