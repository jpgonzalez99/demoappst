module.exports = function () {
   return {
      getOriginAirports: function () {
         return originAirports;
      },
      getDestinationAirports: function () {
         return destinationAirports;
      }
   }
};

var originAirports = [{
   "iataCode": "LAX",
   "airport": "Los Angeles International",
   "city": "Los Angeles",
   "state": "CA",
   "country": "USA",
   "lat": 3.394253611,
   "long": -1.184080744,
}, {
   "iataCode": "GCXO",
   "airport": "Tenerife Norte Airport",
   "city": "Tenerife",
   "state": "SCTF",
   "country": "SPAIN",
   "lat": 3.394253611,
   "long": -1.184080744,
}, {
   "iataCode": "LEMD",
   "airport": "Adolfo Suárez Madrid–Barajas Airport",
   "city": "Madrid",
   "state": "MAD",
   "country": "SPAIN",
   "lat": 3.394253611,
   "long": -1.184080744,
}, {
   "iataCode": "LHR",
   "airport": "London Heathrow Airport",
   "city": "London",
   "state": "EGLL",
   "country": "UK",
   "lat": 3.394253611,
   "long": -1.184080744,
}, {
   "iataCode": "GMZ",
   "airport": "La Gomera Airport",
   "city": "La Gomera",
   "state": "SCTF",
   "country": "Spain",
   "lat": 3.394253611,
   "long": -1.184080744,
}, {
   "iataCode": "GCLP",
   "airport": "Gran Canaria Airport",
   "city": "Gran Canaria",
   "state": "LP",
   "country": "Spain",
   "lat": 3.394253611,
   "long": -1.184080744,
},
{
   "iataCode": "GCLP",
   "airport": "Gran Canaria Airport",
   "city": "Gran Canaria",
   "state": "LP",
   "country": "Spain",
   "lat": 3.394253611,
   "long": -1.184080744,
},
{
   "iataCode": "GCLP",
   "airport": "Gran Canaria Airport",
   "city": "Gran Canaria",
   "state": "LP",
   "country": "Spain",
   "lat": 3.394253611,
   "long": -1.184080744,
}];

var destinationAirports = [{
      "iataCode": "GCXO",
      "airport": "Tenerife Norte Airport",
      "city": "Tenerife",
      "state": "SCTF",
      "country": "SPAIN",
      "lat": 3.394253611,
      "long": -1.184080744,
   },
   {
      "iataCode": "LEMD",
      "airport": "Adolfo Suárez Madrid–Barajas Airport",
      "city": "Madrid",
      "state": "MAD",
      "country": "SPAIN",
      "lat": 3.394253611,
      "long": -1.184080744,
   }
];
