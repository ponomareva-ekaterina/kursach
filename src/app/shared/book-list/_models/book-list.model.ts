import {BookModel} from '../../../book-editor/edit-book/_models/book.model';

export class BookListModel {

  bookList: Array<BookModel> = new Array<BookModel>();

  constructor(data){
    data.bookList.forEach(
      book => {
        this.bookList.push(new BookModel(book));
      }
    );
  }
}
