import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs/Observable";
import "rxjs/add/observable/of";
import "rxjs/add/operator/map";
import {Ingredient} from "./dtos";
import {environment} from '../../environments/environment';


@Injectable()
export class IngredientDataService {

  constructor(private http: HttpClient) { }

  apiUrl = environment.apiBaseUrl + '/api/ingredients';

  public findMatches(query: string): Observable<Ingredient[]> {
    return this.http.get<Ingredient[]>(this.apiUrl + "?q=" + query);
  }

}
