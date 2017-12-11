import {Component, OnInit} from "@angular/core";
import {DataService} from "./app.data.service";
import {Response} from "@angular/http";

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
})
export class AppComponent implements OnInit {

  //get actual data form DB via REST
  ngOnInit():void {
    this.dataService.getGameModesData()
      .subscribe((res:Response) => {
        var actualResponse = res.json();
        this.barChartData = [];
        for (var i = 0; i < actualResponse.length; i++) {
          this.barChartData.push(actualResponse[i].sum);
        }
      });
  }

  constructor(private dataService:DataService) {
  }

  // bar chart
  public barChartData:Array<any> = [{"data": [], "label": "Matches Played"}];
  public barChartType:string = 'bar';
  public barChartLabels:Array<any> = this.getChartLabels();
  public barChartOptions:any = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  public barChartLegend:boolean = true;

  //returns array of labels for chart based on sorted data
  public getChartLabels() {
      this.dataService.getGameModesLabels()
        .subscribe((res:Response) => {

            var actualResponse = res.json() as String[];
            this.barChartLabels = [];
            for (var i = 0; i < actualResponse.length; i++) {
              this.barChartLabels.push(actualResponse[i]);
            }
          }
        );
  }

// events
  public chartClicked(e:any):void {
    console.log(e);
  }

  public chartHovered(e:any):void {
    console.log(e);
  }
}
