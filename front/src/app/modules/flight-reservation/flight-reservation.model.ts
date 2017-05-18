export enum STATE { AIRPORTS, AIRLINES, PASSENGER, RESUME }

export interface Airlines {
   iataCode1: string;
   airport1: string;
   iataCode2: string;
   airport2: string;
   airtime: number;
   avgDelay: number;
   cancellations: number;
}

export interface Passenger {
   clientId: string;
   firstName: string;
   lastName: string;
   dni: string;
   gender: string;
   address: string;
   city: string;
   postalcode: string;
   phoneNumber: string;
}

export interface TravelRoute {
   iataCode1: string;
   iataCode2: string;
}
