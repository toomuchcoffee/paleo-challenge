import {ModuleWithProviders} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {MealListComponent} from "./meal-list/meal-list.component";
import {MealCreateComponent} from "./meal-create/meal-create.component";
import {HomeComponent} from "./home/home.component";

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent, data: {title: 'Paleo Home'} },
  { path: 'meals', component: MealListComponent, data: {title: 'Paleo Meals'} },
  { path: 'meals/new', component: MealCreateComponent, data: {title: 'New Paleo Meal'} }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);
