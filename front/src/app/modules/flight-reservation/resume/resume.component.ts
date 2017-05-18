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
import { FormGroup, FormBuilder } from '@angular/forms';
import { Observable } from 'rxjs/Observable';
import { StInputError } from '@stratio/egeo';

import { Passenger, Airlines, TravelRoute } from '../flight-reservation.model';

@Component({
   selector: 'resume',
   styleUrls: ['./resume.scss'],
   templateUrl: './resume.html',
   changeDetection: ChangeDetectionStrategy.OnPush
})
export class ResumeComponent {

   @Input() airports: TravelRoute;
   @Input() airline: Airlines;
   @Input() passenger: Passenger;

   @Output() book: EventEmitter<Event> = new EventEmitter<Event>();

   public buttonDisabled: boolean = false;

   public form: FormGroup;

   constructor(private _fb: FormBuilder) { }

   ngOnInit(): void {
      this.form = this._fb.group({
         'origin': [this.airline.airport1],
         'destination': [this.airline.airport2],
         'airtime': [this.airline.airtime],
         'avgDelay': [this.airline.avgDelay],
         'cancellations': [this.airline.cancellations],
         'clientId': [this.passenger.clientId],
         'firstName': [this.passenger.firstName],
         'lastName': [this.passenger.lastName],
         'gender': [this.passenger.gender],
         'dni': [this.passenger.dni],
         'address': [this.passenger.address],
         'city': [this.passenger.city],
         'postalcode': [this.passenger.postalcode],
         'phoneNumber': [this.passenger.phoneNumber]
      });
   }
}
