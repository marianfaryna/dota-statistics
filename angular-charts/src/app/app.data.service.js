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
var http_1 = require("@angular/http");
require("rxjs/add/operator/toPromise");
var DataService = (function () {
    function DataService(http) {
        this.http = http;
        this.restGameModeSumsUrl = 'http://localhost:8080/game-mods-data';
        this.restGameModesUrl = 'http://localhost:8080/game-mods';
    }
    //returns json array of data as Observable
    DataService.prototype.getGameModesData = function () {
        return this.http.get(this.restGameModeSumsUrl);
    };
    // return chart labels sorted according to data as Observable
    DataService.prototype.getGameModesLabels = function () {
        return this.http.get(this.restGameModesUrl);
    };
    return DataService;
}());
DataService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http])
], DataService);
exports.DataService = DataService;
//# sourceMappingURL=app.data.service.js.map