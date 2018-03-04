import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs/Observable";
import "rxjs/add/observable/of";
import "rxjs/add/operator/map";
import {Meal, Ingredient} from "../shared/dtos";

@Injectable()
export class MealDataService {

  constructor(private http: HttpClient) { }

  apiUrl = 'http://localhost:8080/api/meals';

  public getMeals(): Observable<Meal[]> {
    return this.http.get<Meal[]>(this.apiUrl);
  }

  public addMeal(meal: Meal): Observable<Meal> {
    return this.http.post<Meal>(this.apiUrl, meal);
  }
}
