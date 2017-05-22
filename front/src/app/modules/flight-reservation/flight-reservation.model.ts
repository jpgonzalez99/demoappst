export enum STATE { AIRPORTS, FLIGHT, PASSENGER, RESUME }

export interface Airport {
   city: string;
   country: string;
   iataCode: string;
   latitude: number;
   longitude: number;
   name: string;
   state: string;
}

export interface Flight {
   averageCarrierDelay: number;
   averageFlightDelay: number;
   carrier: Carrier;
   destination: Airport;
   flightId: number;
   origin: Airport;
   plane: Plane;
   price: number;
}

export interface Carrier {
   code: string;
   description: string;
}

export interface Passenger {
   firstName: string;
   lastName: string;
   dni: string;
   gender: string;
   address: string;
   city: string;
   postalcode: string;
   phoneNumber: string;
}

export interface Plane {
   manufacturer: string;
   model: string;
   planeId: number;
   seats: number;
}

export interface TravelRoute {
   iataCode1: string;
   iataCode2: string;
}


export interface Book {
   iataOrigin: string;
   iataDestination: string;
   passenger: Passenger;
   price: number;
   carrier: string;
}
