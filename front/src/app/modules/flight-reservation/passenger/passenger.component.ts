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

import { Component, ChangeDetectionStrategy, Input, Output, EventEmitter, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Observable } from 'rxjs/Observable';
import { StInputError } from '@stratio/egeo';

import { Passenger } from '../flight-reservation.model';

@Component({
   selector: 'passenger-info',
   styleUrls: ['./passenger.scss'],
   templateUrl: './passenger.html',
   changeDetection: ChangeDetectionStrategy.OnPush
})
export class PassengerComponent implements OnInit {

   @Input() passengerModel: Passenger;
   @Output() fullFillPassenger: EventEmitter<Passenger> = new EventEmitter<Passenger>();
   public errors: StInputError = {
      generic: 'Error',
      required: 'This field is required',
      pattern: 'Only accept numbers'
   };
   public onlyNumbers: string = '[0-9]+';
   public forceValidations: boolean = false;

   public form: FormGroup;

   constructor(private _fb: FormBuilder) { }

   ngOnInit(): void {
      this.form = this._fb.group({
         'clientId': [this.passengerModel.clientId, [Validators.required, Validators.pattern(this.onlyNumbers)]],
         'firstName': [this.passengerModel.firstName, [Validators.required]],
         'lastName': [this.passengerModel.lastName, [Validators.required]],
         'gender': [this.passengerModel.gender, [Validators.required]],
         'dni': [this.passengerModel.dni, [Validators.required]],
         'address': [this.passengerModel.address, [Validators.required]],
         'city': [this.passengerModel.city, [Validators.required]],
         'postalcode': [this.passengerModel.postalcode, [Validators.required, Validators.pattern(this.onlyNumbers)]],
         'phoneNumber': [this.passengerModel.phoneNumber, [Validators.required, Validators.pattern(this.onlyNumbers)]]
      });
   }

   sendForm(): void {
      if (this.form.valid) {
         this.fullFillPassenger.emit(this.fullFillModel());
      } else {
         this.forceValidations = true;
      }
   }

   private fullFillModel(): Passenger {
      return {
         address: this.form.get('address').value,
         city: this.form.get('city').value,
         clientId: this.form.get('clientId').value,
         dni: this.form.get('dni').value,
         firstName: this.form.get('firstName').value,
         gender: this.form.get('gender').value,
         lastName: this.form.get('lastName').value,
         phoneNumber: this.form.get('phoneNumber').value,
         postalcode: this.form.get('postalcode').value
      };
   }
}
