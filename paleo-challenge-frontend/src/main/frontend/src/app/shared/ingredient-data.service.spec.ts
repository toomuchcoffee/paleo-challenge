import { TestBed, inject } from '@angular/core/testing';

import { IngredientDataService } from './ingredient-data.service';

describe('IngredientDataService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [IngredientDataService]
    });
  });

  it('should be created', inject([IngredientDataService], (service: IngredientDataService) => {
    expect(service).toBeTruthy();
  }));
});
