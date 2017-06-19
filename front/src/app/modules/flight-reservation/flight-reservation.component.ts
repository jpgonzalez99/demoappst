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

import { Component, ChangeDetectionStrategy, ChangeDetectorRef } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {
   StModalService,
   StModalButton,
   StModalMainTextSize,
   StModalType,
   StModalResponse
} from '@stratio/egeo';

import { FlightReservationService } from './flight-reservation.service';
import { STATE, TravelRoute, Passenger, Book, Flight } from './flight-reservation.model';


@Component({
   selector: 'flight-reservation',
   styleUrls: ['./flight-reservation.scss'],
   templateUrl: './flight-reservation.html',
   changeDetection: ChangeDetectionStrategy.OnPush
})
export class FlightReservationComponent {

   public state: STATE = STATE.AIRPORTS;
   public flightList: Observable<Flight[]>;
   public passengerModel: Passenger;

   public bookedRoute: TravelRoute;
   public bookedFlight: Flight;
   public bookedPassenger: Passenger;

   constructor(
      private service: FlightReservationService,
      private _modalService: StModalService,
      private _cd: ChangeDetectorRef
   ) {
      this.initAll();
   }


   public onSelectRoute(flightRoute: TravelRoute): void {
      this.bookedRoute = flightRoute;
      this.flightList = this.service.getFlights(flightRoute.iataCode1, flightRoute.iataCode2);
      this.state = STATE.FLIGHT;
   }

   public onSelectFlight(flight: Flight): void {
      this.bookedFlight = flight;
      this.state = STATE.PASSENGER;
   }

   public onFullFillPassenger(passenger: Passenger): void {
      this.bookedPassenger = passenger;
      this.state = STATE.RESUME;
   }

   public isAirports(): boolean {
      return this.state === STATE.AIRPORTS;
   }

   public isFlight(): boolean {
      return this.state === STATE.FLIGHT;
   }

   public isPassenger(): boolean {
      return this.state === STATE.PASSENGER;
   }

   public isResume(): boolean {
      return this.state === STATE.RESUME;
   }

   public onBook(end: boolean): void {
      let finalBook: Book = {
         passenger: {
            address: this.bookedPassenger.address,
            city: this.bookedPassenger.city,
            dni: this.bookedPassenger.dni,
            firstName: this.bookedPassenger.firstName,
            gender: this.bookedPassenger.gender,
            lastName: this.bookedPassenger.lastName,
            phoneNumber: this.bookedPassenger.phoneNumber,
            postalcode: this.bookedPassenger.postalcode,
         },
         iataOrigin: this.bookedFlight.origin.iataCode,
         iataDestination: this.bookedFlight.destination.iataCode,
         carrier: this.bookedFlight.carrier.code,
         price: this.bookedFlight.price
      };
      this.service.postBooking(finalBook).subscribe(response => {
         if (response.status < 400) {
            this.initAll();
            this.showModal('Flight booked correctly, thanks for use our service', true);

         } else {
            this.showModal(response.text(), false);
         }
         this._cd.markForCheck();
      });
   }

   private initAll(): void {
      this.state = STATE.AIRPORTS;
      this.bookedFlight = undefined;
      this.bookedPassenger = undefined;
      this.bookedRoute = undefined;
      this.flightList = undefined;
      this.passengerModel = {
         address: '',
         city: '',
         dni: '',
         firstName: '',
         gender: '',
         lastName: '',
         phoneNumber: '',
         postalcode: ''
      };
   }

   private showModal(message: string, ok: boolean): void {

      let buttons: StModalButton[] = [
         { icon: 'icon-circle-check', iconLeft: true, label: ok ? 'Ok' : 'Go back', primary: true, response: StModalResponse.YES }
      ];
      this._modalService.show({
         qaTag: 'tag-message',
         modalTitle: 'Booking Result',
         buttons: buttons,
         message: message,
         mainText: StModalMainTextSize.BIG,
         modalType: ok ? StModalType.INFO : StModalType.WARNING
      });
   }

}
