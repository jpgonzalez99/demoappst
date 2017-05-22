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

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { TranslateModule } from '@ngx-translate/core';
import { EgeoModule } from '@stratio/egeo';

import { routing } from './flight-reservation.routing';

import { FlightReservationService } from './flight-reservation.service';
import { FlightReservationComponent } from './flight-reservation.component';
import { AirportsComponent } from './airports/airports.component';
import { FlightComponent } from './flight/flight.component';
import { PassengerComponent } from './passenger/passenger.component';
import { ResumeComponent } from './resume/resume.component';

@NgModule({
   imports: [
      CommonModule,
      TranslateModule,
      EgeoModule,
      routing,
      ReactiveFormsModule
   ],
   declarations: [
      FlightReservationComponent,
      AirportsComponent,
      FlightComponent,
      PassengerComponent,
      ResumeComponent
   ],
   providers: [FlightReservationService]
})

export class FlightReservationModule { }
