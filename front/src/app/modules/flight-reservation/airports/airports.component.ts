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

import { Component, ChangeDetectionStrategy, OnInit, Output, EventEmitter } from '@angular/core';
import { StDropDownMenuItem } from '@stratio/egeo';
import { Observable } from 'rxjs/Observable';

import { FlightReservationService } from '../flight-reservation.service';
import { TravelRoute } from '../flight-reservation.model';

@Component({
   selector: 'airports',
   styleUrls: ['./airports.scss'],
   templateUrl: './airports.html',
   changeDetection: ChangeDetectionStrategy.OnPush
})
export class AirportsComponent implements OnInit {
   @Output() selection: EventEmitter<TravelRoute> = new EventEmitter<TravelRoute>();

   public origin: Observable<StDropDownMenuItem[]>;
   public destination: Observable<StDropDownMenuItem[]>;
   public activeDestination: boolean = false;

   selectedOrigin: StDropDownMenuItem;
   selectedDestination: StDropDownMenuItem;

   constructor(
      private service: FlightReservationService) { }

   ngOnInit(): void {
      this.origin = this.service.getOriginAirport();
   }

   onChangeOrigin(active: StDropDownMenuItem): void {
      this.selectedOrigin = active;
      this.destination = this.service.getDestinationAirports(active.value);
   }

   onChangeDestination(active: StDropDownMenuItem): void {
      this.selectedDestination = active;
   }

   isDestinationActive(): boolean {
      return this.selectedOrigin !== undefined;
   }

   isSearchActive(): boolean {
      return this.selectedOrigin !== undefined && this.selectedDestination !== undefined;
   }

   searchFlights(): void {
      this.selection.emit({iataCode1: this.selectedOrigin.value, iataCode2: this.selectedDestination.value});
   }
}
