import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from "../../../environments/environment";


@Injectable()
export class Api {
  protected baseUrl = environment.apiUrl; //url рест сервиса

  protected httpOptions = {
    headers: new HttpHeaders({
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Credentials': 'true',
      'Access-Control-Allow-Headers': 'Origin, Accept, X-Requested-With, Content-Type,' +
                                      ' Access-Control-Request-Method, Authorization, Access-Control-Allow-Origin',
      'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, OPTIONS, HEAD, PATCH',
      'Content-Type':  'application/json',
    })
  };

  constructor(public httpClient: HttpClient) {
  }

  protected getUrl(url: string = ''): string {
    return this.baseUrl + url;
  }

}
