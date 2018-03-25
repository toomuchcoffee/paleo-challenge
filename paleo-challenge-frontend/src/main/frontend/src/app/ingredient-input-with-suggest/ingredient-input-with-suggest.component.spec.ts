import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IngredientInputWithSuggestComponent } from './ingredient-input-with-suggest.component';

describe('IngredientInputWithSuggestComponent', () => {
  let component: IngredientInputWithSuggestComponent;
  let fixture: ComponentFixture<IngredientInputWithSuggestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IngredientInputWithSuggestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IngredientInputWithSuggestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
