import { Component, Input, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormArray, FormGroup } from '@angular/forms';
import {IngredientDataService} from "../shared/ingredient-data.service";


@Component({
  selector: 'app-ingredient-input-with-suggest',
  templateUrl: './ingredient-input-with-suggest.component.html',
  styleUrls: ['./ingredient-input-with-suggest.component.css']
})
export class IngredientInputWithSuggestComponent {
  @Input('formArray')
  public formArray: FormArray;

  @Input('index')
  public index: number;

  public ingredientForm: FormGroup;

  @ViewChild('suggest')
  public suggestion: ElementRef;

  constructor(private searchService: IngredientDataService) { }

  ngOnInit() {
    this.ingredientForm = <FormGroup>this.formArray.controls[this.index];
  }

  acceptSuggestion() {
    let suggestedValue = this.suggestion.nativeElement.textContent;
    console.log("suggestion accepted: " + suggestedValue);
    this.ingredientForm.controls['name'].setValue(suggestedValue);
    this.suggestion.nativeElement.textContent = '';
  }

  searchSuggestion() {
    let query = this.ingredientForm.controls['name'].value;
    console.log("searching for ..." + query);
    if (query.length < 1) {
      this.suggestion.nativeElement.textContent = '';
      return;
    }

    this.searchService.findMatches(query).subscribe(matches => {
      if (matches.length) {
        this.suggestion.nativeElement.textContent = matches[0].name;
      } else {
        this.suggestion.nativeElement.textContent = '';
      }
    });
  }

  removeIngredient() {
    this.formArray.removeAt(this.index)
  }

}
