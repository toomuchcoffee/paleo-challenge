import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router, ActivatedRoute} from "@angular/router";
import {MealDataService} from "../shared/meal-data.service";


@Component({
  selector: 'app-meal-create',
  templateUrl: './meal-create.component.html',
  styleUrls: ['./meal-create.component.css']
})
export class MealCreateComponent implements OnInit {
  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private mealDataService: MealDataService,
    private router: Router,
    private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.form = this.formBuilder.group({
      name: [
        '', Validators.required
      ],
      ingredients: this.formBuilder.array([])
    });
  }

  createIngredient(): FormGroup {
    return this.formBuilder.group({
      name: [
        '', Validators.required
      ]
    });
  }

  addIngredient() {
    this.getIngredients().push(this.createIngredient())
  }

  removeIngredient(i: number) {
    this.getIngredients().removeAt(i)
  }

  getIngredients(): FormArray {
    return <FormArray>this.form.controls['ingredients'];
  }

  onSubmit(value) {
    console.log(value);
    this.mealDataService.addMeal(value).subscribe(
      v => this.router.navigate(['../'], { relativeTo: this.activatedRoute })
    );
  }

}
