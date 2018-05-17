import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {FileHolder} from 'angular2-image-upload';
import {BookModel} from '../../../../book-editor/edit-book/_models/book.model';
import {Api} from '../../../core/api';
import {BookListModel} from '../../_models/book-list.model';

@Injectable()
export class BookCoverService extends Api {

  private localUrl = '/book/cover';

  constructor(public httpClient: HttpClient) {
    super(httpClient);
  }

  public get(bookId: number, authorId: number): Observable<any>{
    let url = this.localUrl + '/download?'
                            + 'bookId=' + bookId
                            + '&authorId=' + authorId;

    return this.httpClient.get(this.getUrl(url));
  }

}
