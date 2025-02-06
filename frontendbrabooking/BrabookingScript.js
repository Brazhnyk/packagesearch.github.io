
const inputUrlIata = "http://localhost:8080/packages?arrival=" 
const inputUrlOffers = "http://localhost:8080/offers?arrival=" 
function findIataFunc() {
   
    input = document.querySelector("#arrivalPackages").value
    hiddenElementOffer = document.getElementById("formOffers")
    hiddenElementOffer.style.display = "none"
    hiddenResultIataDiv = document.getElementById("resultIataDiv")
    hiddenResultIataDiv.style.display = "table"
    hiddenButtonCloseIataTable = document.getElementById("buttonCloseIataTable")
    hiddenButtonCloseIataTable.style.display = "table"
    hiddenResultIataTable = document.getElementById("resultIataTable")
    hiddenResultIataTable.style.display = "table"  
    hiddenBrabooking = document.getElementById("booking2020")
    hiddenBrabooking.style.display = "none"
    getIataTable(inputUrlIata, input)
}

function getIataTable(inputUrlIata, iataCodeInput) {
   fetch(inputUrlIata+iataCodeInput)
.then(res => res.json())
  .then(function(products) {
   

      let placeholder = document.querySelector("#iataInput")
      let out = ""

      for (let product of products) {
         out += `
         <tr id="tableIataHover">
            <td class = "offersBorderOff"><div class="testCss">${product.id}</td>
            <td class = "offersBorderOff"><div class="testCss">${product.flightProvider}</td>
            <td class = "offersBorderOff"><div class="testCss">${product.departureAirport}</td>
            <td class = "offersBorderOff"><div class="testCss">${product.arrivalAirport}</td>
            <td class = "offersBorderOff"><div class="testCss">${product.flightPrice}</td>
            <td class = "offersBorderOff"><div class="testCss">${product.hotelName}</td>
            <td class = "offersBorderOff"><div class="testCss">${product.hotelPrice}</td>
         </tr>
         ` 
      }
      placeholder.innerHTML = out
  })
}

function getOffersTable(inputUrlOffers, arrival, persons, nigths) {
arrival = arrival
persons = "&persons=" + persons
nigths = "&los=" + nigths
   fetch(inputUrlOffers + arrival + persons + nigths)
.then(res => res.json())
.then(function(products) {
   
      let placeholder = document.querySelector("#offersInput")
      let out = ""

      for (let product of products) {
         out += `
      <div class = "test2" >
         <tr class = "test11" id="test3">
            <td  id="leftColor"class = "offersBorderOff"><div class="testCss">${product.id}</div></td> 
            <td class = "offersBorderOff"><div class="testCss">${product.flightProvider}</div></td>
            <td class = "offersBorderOff"><div class="testCss">${product.departureAirport}</div></td>
            <td class = "offersBorderOff"><div class="testCss">${product.arrivalAirport}</div></td>
         <td class = "offersBorderOff">
          <details> 
               <ul id="inputList">
                  <div id="hotelIdInput" align="middle">Hotel id: ${product.hotelInfo.id}</div>
                  <div id="hotelSloganInput" align="middle">"${product.hotelInfo.slogan}"</div>
                  <img id="imgOffersBorder" width="500" height="200" src = "${product.hotelInfo.hotelImageURL}">
               </ul>
          <summary><strong>${product.hotelInfo.hotelName}<strong/></summary>    
           </details>
         </td>
         <td class = "offersBorderOff"><div class="testCss">${product.flightPrice}</div></td>
         <td class = "offersBorderOff"><div class="testCss">${product.hotelPrice}</div></td>
         <td class = "offersBorderOff"><div class="testCss">${product.totalPrice}</div></td>
        </div>
         </tr>
         ` 
        
      }
      placeholder.innerHTML = out
  })
}

function findOffersFunc() {
   
   arrival = document.querySelector("#arrivalOffers").value
   persons = document.querySelector("#personsOffers").value
   nights = document.querySelector("#losOffers").value
   hiddenElementFindIata = document.getElementById("findIataDiv")
   hiddenElementFindIata.style.display = "none"
   hiddenBrabooking = document.getElementById("booking2020")
   hiddenBrabooking.style.display = "none"
   document.getElementById("formOffers").style.top = "5%"
   document.getElementById("formOffers").style.marginTop = "3%"
   document.getElementById("formOffers").style.paddingTop = "0.5%"
   document.getElementById("formOffers").style.paddingBottom = "2%"
   document.getElementById("buttonCloseOffersTable").style.display = "table"
   document.getElementById("resultOffersTable").style.display = "table"
   document.getElementById("resultOffersTable").style.top = "24%"
   getOffersTable(inputUrlOffers, arrival, persons, nights)
}

function functionTest(){
   document.querySelector(".test2").style.display = "table"
  
}






 