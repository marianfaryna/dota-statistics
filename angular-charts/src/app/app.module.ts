import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent }  from './app.component';
import { DataService } from './app.data.service';
import { ChartsModule } from 'ng2-charts/ng2-charts';

@NgModule({
  imports:      [ BrowserModule, ChartsModule ],
  declarations: [ AppComponent ],
  bootstrap:    [ AppComponent ],
  providers: [DataService]
})
export class AppModule { }
