import { TestBed, inject } from '@angular/core/testing';

import { MealDataService } from './meal-data.service';

describe('MealDataService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MealDataService]
    });
  });

  it('should be created', inject([MealDataService], (service: MealDataService) => {
    expect(service).toBeTruthy();
  }));
});
