import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule }    from '@angular/http';

import { AppComponent }  from './app.component';
import { DataService } from './app.data.service';
import { ChartsModule } from 'ng2-charts/ng2-charts';

@NgModule({
  imports:      [ BrowserModule, ChartsModule,HttpModule ],
  declarations: [ AppComponent ],
  bootstrap:    [ AppComponent ],
  providers: [DataService]
})
export class AppModule { }
