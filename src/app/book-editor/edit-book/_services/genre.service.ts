import {Api} from '../../../shared/core/api';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class GenreService extends Api {

  private localUrl = '/genre';

  constructor(public httpClient: HttpClient) {
    super(httpClient);
  }

  public getAll(): Observable<any> {
    let url = this.localUrl + '/all';
    return this.httpClient.get(this.getUrl(url));
  }
}
