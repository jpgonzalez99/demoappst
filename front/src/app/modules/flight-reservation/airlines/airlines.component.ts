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

import { Airlines } from '../flight-reservation.model';

@Component({
   selector: 'airlines-list',
   styleUrls: ['./airlines.scss'],
   templateUrl: './airlines.html',
   changeDetection: ChangeDetectionStrategy.OnPush
})
export class AirlineComponent {
   @Input() flightList: Airlines[];
   @Output() selectedFlight: EventEmitter<Airlines> = new EventEmitter<Airlines>();

   public fields: StTableHeader[] = [
      { id: 'airport1', label: 'From' },
      { id: 'airport2', label: 'To' },
      { id: 'airtime', label: 'Flight duration' },
      { id: 'avgDelay', label: 'Avg Delay' },
      { id: 'cancellations', label: 'Cancellations' }];

   constructor() { }

   onSelectFlight(flight: Airlines): void {
      this.selectedFlight.emit(flight);
   }
}
