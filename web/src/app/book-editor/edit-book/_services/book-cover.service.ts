import {Api} from '../../../shared/core/api';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {BookModel} from '../_models/book.model';
import {FileHolder} from 'angular2-image-upload';

@Injectable()
export class BookCoverService extends Api {

  private localUrl = '/book/cover';

  constructor(public httpClient: HttpClient) {
    super(httpClient);
  }

  public post(image: FileHolder, book: BookModel) {
    let url = this.localUrl + '/upload';
    let fileName = book.id + '-' + book.author.id + '.' + image.file.name.split('.')[1];
    let fd = new FormData();
    fd.append('file', image.file, fileName);
    return this.httpClient.post(this.getUrl(url), fd);
  }
}
