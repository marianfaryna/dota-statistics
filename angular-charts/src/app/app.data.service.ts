import { Injectable } from '@angular/core';

@Injectable()
export class DataService {
  getHeroNames(): String[] {
    return ['January', 'February', 'March', 'April', 'May', 'June', 'July'];
  }

  getHeroDataSet(): Array<any> {
    return [
      {data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A'},
      {data: [28, 48, 40, 19, 86, 27, 90], label: 'Series B'},
      {data: [18, 48, 77, 9, 100, 27, 40], label: 'Series C'}
    ];
  }
}
