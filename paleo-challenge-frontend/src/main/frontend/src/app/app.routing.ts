import {ModuleWithProviders} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {MealListComponent} from "./meal-list/meal-list.component";
import {MealCreateComponent} from "./meal-create/meal-create.component";

const routes: Routes = [
  {
    path: 'meals',
    component: MealListComponent
  },
  {
    path: 'meals/new',
    component: MealCreateComponent
  },
  {
    path: '',
    redirectTo: '/meals',
    pathMatch: 'full'
  }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);
