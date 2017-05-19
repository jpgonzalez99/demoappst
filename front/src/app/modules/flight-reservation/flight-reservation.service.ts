import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { StDropDownMenuItem } from '@stratio/egeo';
import { Observable } from 'rxjs/Observable';
import { Observer } from 'rxjs/Observer';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';  // debug
import 'rxjs/add/operator/catch';

import { ConfigService } from '@app/core';
import { Airlines, Book } from './flight-reservation.model';

@Injectable()
export class FlightReservationService {

   origins: string = 'origins';
   destination: string = 'destinationsFrom/';
   airlines: string = 'flightsFrom/';
   book: string = 'result';

   private apiUrl: string;

   constructor(private http: Http, public configService: ConfigService) {
      this.apiUrl = this.configService.config.API_URL;
   }

   getOriginAirport(): Observable<StDropDownMenuItem[]> {
      return this.http.get(this.apiUrl + this.origins)
         .map(response => this.parseJson(response.json()));
   }

   getDestinationAirports(iataCode: string): Observable<StDropDownMenuItem[]> {
      return this.http.get(this.apiUrl + this.destination + iataCode)
         .map(response => this.parseJson(response.json()));
   }

   getAirlines(iata1: string, iata2: string): Observable<Airlines[]> {
      // /flightsFrom/{originIataCode}/to/{destinationIataCode}
      return this.http.get(`${this.apiUrl}${this.airlines}${iata1}to${iata2}`)
         .map(response => response.json() as Airlines[]);
   }

   postBooking(book: Book): Observable<Response> {
      return this.http.post(`${this.apiUrl}${this.book}`, JSON.stringify(book))
         .catch((err) => this._serverError(err));
   }

   private _serverError(err: any): any {
      if (err instanceof Response) {
         return Observable.create((observer: Observer<Response>) => {
            observer.next(err);
            observer.complete();
         });
      }
      return Observable.throw(err || 'backend server error');
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
