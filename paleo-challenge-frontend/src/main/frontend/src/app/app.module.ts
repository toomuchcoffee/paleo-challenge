import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';

import {AppComponent} from './app.component';
import {routing} from "./app.routing";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import {MealListComponent} from './meal-list/meal-list.component';
import {MealCreateComponent} from './meal-create/meal-create.component';
import {MealDataService} from './shared/meal-data.service';


@NgModule({
  declarations: [
    AppComponent,
    MealListComponent,
    MealCreateComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    routing,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [
    MealDataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
