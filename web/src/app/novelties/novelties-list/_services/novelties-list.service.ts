import {Api} from '../../../shared/core/api';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable()
export class NoveltiesListService extends Api {

  private localUrl = '/book/list';

  constructor(public httpClient: HttpClient) {
    super(httpClient);
  }

}
