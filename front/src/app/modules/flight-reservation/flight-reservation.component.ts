/*
 * Copyright (C) 2016 Stratio (http://stratio.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import { Component, ChangeDetectionStrategy } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { FlightReservationService } from './flight-reservation.service';
import { STATE, TravelRoute, Airlines, Passenger } from './flight-reservation.model';


@Component({
   selector: 'flight-reservation',
   styleUrls: ['./flight-reservation.scss'],
   templateUrl: './flight-reservation.html',
   changeDetection: ChangeDetectionStrategy.OnPush
})
export class FlightReservationComponent {

   public state: STATE = STATE.AIRPORTS;
   public flightList: Observable<Airlines[]>;
   public passengerModel: Passenger;

   public bookedRoute: TravelRoute;
   public bookedAirline: Airlines;
   public bookedPassenger: Passenger;

   constructor(private service: FlightReservationService) {
      this.initAll();
   }


   public onSelectRoute(flightRoute: TravelRoute): void {
      this.bookedRoute = flightRoute;
      this.flightList = this.service.getAirlines(flightRoute.iataCode1, flightRoute.iataCode2);
      this.state = STATE.AIRLINES;
   }

   public onSelectFlight(flight: Airlines): void {
      this.bookedAirline = flight;
      this.state = STATE.PASSENGER;
   }

   public onFullFillPassenger(passenger: Passenger): void {
      this.bookedPassenger = passenger;
      this.state = STATE.RESUME;
   }

   public isAirports(): boolean {
      return this.state === STATE.AIRPORTS;
   }

   public isAirlines(): boolean {
      return this.state === STATE.AIRLINES;
   }

   public isPassenger(): boolean {
      return this.state === STATE.PASSENGER;
   }

   public isResume(): boolean {
      return this.state === STATE.RESUME;
   }

   public onEnd(end: boolean): void {
      this.initAll();
   }

   private initAll(): void {
      this.state = STATE.AIRPORTS;
      this.bookedAirline = undefined;
      this.bookedPassenger = undefined;
      this.bookedRoute = undefined;
      this.flightList = undefined;
      this.passengerModel = {
         address: '',
         city: '',
         clientId: '',
         dni: '',
         firstName: '',
         gender: '',
         lastName: '',
         phoneNumber: '',
         postalcode: ''
      };
   }

}
