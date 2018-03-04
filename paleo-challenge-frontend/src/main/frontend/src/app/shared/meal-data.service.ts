import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs/Observable";
import "rxjs/add/observable/of";
import "rxjs/add/operator/map";
import {Meal} from "../shared/meal";
import {Ingredient} from "../shared/ingredient";

@Injectable()
export class MealDataService {

  constructor(private http: HttpClient) { }

  apiUrl = 'http://localhost:8080/api/meals';

  getMeals(): Observable<Meal[]> {
    return this.http.get<Meal[]>(this.apiUrl);
  }

}
