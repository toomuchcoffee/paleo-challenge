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
    console.log("suggestion accepted: " + this.suggestion.nativeElement.value);
    this.ingredientForm.controls['name'].setValue(this.suggestion.nativeElement.value);
  }

  searchSuggestion() {
    let query = this.ingredientForm.controls['name'].value;
    console.log("searching for ..." + query)
    this.searchService.findMatches(query).subscribe(matches => {
      if (matches.length) {
        this.suggestion.nativeElement.value = matches[0].name;
      } else {
        this.suggestion.nativeElement.value = '';
      }
    });
  }

  removeIngredient() {
    this.formArray.removeAt(this.index)
  }

}
