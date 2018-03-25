import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';

import {AppComponent} from './app.component';
import {routing} from "./app.routing";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import {MealListComponent} from './meal-list/meal-list.component';
import {MealCreateComponent} from './meal-create/meal-create.component';
import { IngredientInputWithSuggestComponent } from './ingredient-input-with-suggest/ingredient-input-with-suggest.component';
import {MealDataService} from './shared/meal-data.service';
import {IngredientDataService} from './shared/ingredient-data.service';
import { HomeComponent } from './home/home.component';


@NgModule({
  declarations: [
    AppComponent,
    MealListComponent,
    MealCreateComponent,
    HomeComponent,
    IngredientInputWithSuggestComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    routing,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [
    MealDataService,
    IngredientDataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
