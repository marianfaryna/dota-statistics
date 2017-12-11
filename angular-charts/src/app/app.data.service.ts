import {Injectable} from "@angular/core";
import {Response, Http} from "@angular/http";
import "rxjs/add/operator/toPromise";
import {Observable} from "rxjs/Observable";

@Injectable()
export class DataService {
  private restGameModeSumsUrl = 'http://localhost:8080/game-mods-data';
  private restGameModesUrl = 'http://localhost:8080/game-mods';

  constructor(private http:Http) {
  }

  //returns json array of data as Observable
  getGameModesData():Observable<Response> {
    return this.http.get(this.restGameModeSumsUrl);
  }

  // return chart labels sorted according to data as Observable
  getGameModesLabels():Observable<Response> {
    return this.http.get(this.restGameModesUrl);
  }

}
