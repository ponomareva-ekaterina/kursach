import {Api} from '../../core/api';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {RequestParams} from '../_models/request-params.model';
import {BookListModel} from '../_models/book-list.model';

@Injectable()
export class BookListService extends Api {

  protected localUrl = '/book/list';

  constructor(public httpClient: HttpClient) {
    super(httpClient);
  }

  public get(requestParams: RequestParams): Observable<BookListModel> {
    let params = requestParams.toUrl();
    let url = this.localUrl + '/get';

    if(params !== ''){
      url += '?' + params;
    }
    return this.httpClient.get<BookListModel>(this.getUrl(url));

  }

}
