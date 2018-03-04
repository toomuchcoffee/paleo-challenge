import { Component, OnInit } from '@angular/core';
import { MealDataService } from "../shared/meal-data.service";
import {Meal} from "../shared/meal";
import {Ingredient} from "../shared/ingredient";

@Component({
  selector: 'app-meal-list',
  templateUrl: './meal-list.component.html',
  styleUrls: ['./meal-list.component.css']
})
export class MealListComponent implements OnInit {

  meals: Meal[];

  constructor(private mealDataService: MealDataService) { }

  ngOnInit() {
    this.mealDataService.getMeals().subscribe(meals => this.meals = meals);
  }

}
