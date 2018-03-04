import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { MealListComponent } from './meal-list/meal-list.component';
import { MealDataService } from './shared/meal-data.service';


@NgModule({
  declarations: [
    AppComponent,
    MealListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
  ],
  providers: [
    MealDataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
