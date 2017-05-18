import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { StDropDownMenuItem } from '@stratio/egeo';

import { Airlines } from './flight-reservation.model';

@Injectable()
export class FlightReservationService {

   api: string = 'http://localhost:3005/';
   origins: string = 'origins';
   destination: string = 'destinationsFrom/';
   airlines: string = 'flightsFrom/';

   constructor(private http: Http) { }

   getOriginAirport(): Observable<StDropDownMenuItem[]> {
      return this.http.get(this.api + this.origins)
         .map(response => this.parseJson(response.json()));
   }

   getDestinationAirports(iataCode: string): Observable<StDropDownMenuItem[]> {
      return this.http.get(this.api + this.destination + iataCode)
         .map(response => this.parseJson(response.json()));
   }

   getAirlines(iata1: string, iata2: string): Observable<Airlines[]> {
      // /flightsFrom/{originIataCode}/to/{destinationIataCode}
      return this.http.get(`${this.api}${this.airlines}${iata1}to${iata2}`)
         .map(response => response.json() as Airlines[]);
   }

   private parseJson(response: any[]): StDropDownMenuItem[] {
      return response.map(airport => {
         return {
            label: airport.airport,
            value: airport.iataCode
         };
      });
   }
}
