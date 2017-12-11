"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var app_data_service_1 = require("./app.data.service");
var AppComponent = (function () {
    function AppComponent(dataService) {
        this.dataService = dataService;
        // bar chart
        this.barChartData = [{ "data": [], "label": "Matches Played" }];
        this.barChartType = 'bar';
        this.barChartLabels = this.getChartLabels();
        this.barChartOptions = {
            scaleShowVerticalLines: false,
            responsive: true
        };
        this.barChartLegend = true;
    }
    //get actual data form DB via REST
    AppComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.dataService.getGameModesData()
            .subscribe(function (res) {
            var actualResponse = res.json();
            _this.barChartData = [];
            for (var i = 0; i < actualResponse.length; i++) {
                _this.barChartData.push(actualResponse[i].sum);
            }
        });
    };
    //returns array of labels for chart based on sorted data
    AppComponent.prototype.getChartLabels = function () {
        var _this = this;
        this.dataService.getGameModesLabels()
            .subscribe(function (res) {
            var actualResponse = res.json();
            _this.barChartLabels = [];
            for (var i = 0; i < actualResponse.length; i++) {
                _this.barChartLabels.push(actualResponse[i]);
            }
        });
    };
    // events
    AppComponent.prototype.chartClicked = function (e) {
        console.log(e);
    };
    AppComponent.prototype.chartHovered = function (e) {
        console.log(e);
    };
    return AppComponent;
}());
AppComponent = __decorate([
    core_1.Component({
        selector: 'my-app',
        templateUrl: './app.component.html',
    }),
    __metadata("design:paramtypes", [app_data_service_1.DataService])
], AppComponent);
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map