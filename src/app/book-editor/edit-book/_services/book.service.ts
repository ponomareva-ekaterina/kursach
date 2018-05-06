import {Api} from '../../../shared/core/api';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient} from '@angular/common/http';
import {BookModel} from '../_models/book.model';

@Injectable()
export class BookService extends Api {

  private localUrl = '/book';

  constructor(public httpClient: HttpClient) {
    super(httpClient);
  }

  public post(book: BookModel) {
    let url = this.localUrl + '/add';
    return this.httpClient.post(this.getUrl(url), book);
  }
}
