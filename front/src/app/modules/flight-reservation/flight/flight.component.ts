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

import { Component, ChangeDetectionStrategy, Input, Output, EventEmitter } from '@angular/core';
import { StTableHeader } from '@stratio/egeo';

import { Flight } from '../flight-reservation.model';

@Component({
   selector: 'flight-list',
   styleUrls: ['./flight.scss'],
   templateUrl: './flight.html',
   changeDetection: ChangeDetectionStrategy.OnPush
})
export class FlightComponent {
   @Input() flightList: Flight[];
   @Output() selectedFlight: EventEmitter<Flight> = new EventEmitter<Flight>();

   public fields: StTableHeader[] = [
      { id: 'airport1', label: 'From' },
      { id: 'airport2', label: 'To' },
      { id: 'averageCarrierDelay', label: 'Avg Carrier Delay' },
      { id: 'averageFlightDelay', label: 'Avg Flight Delay' },
      { id: 'price', label: 'Price' }
   ];

   constructor() { }

   onSelectFlight(flight: Flight): void {
      this.selectedFlight.emit(flight);
   }
}
