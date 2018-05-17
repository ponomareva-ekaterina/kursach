import {Component, HostListener, Input, OnInit} from '@angular/core';
import {BookListService} from './_services/book-list.service';
import {BookListModel} from './_models/book-list.model';
import {RequestParams} from './_models/request-params.model';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css'],
  providers: [
    BookListService
  ]
})
export class BookListComponent implements OnInit {

  cols: number = 1;

  data: BookListModel;

  constructor(
    private bookListService: BookListService
  ) { }

  ngOnInit() {
    this.bookListService.get(new RequestParams()).subscribe(
      response => {
        this.data = new BookListModel(response);
      }
    );
    this.calculateColNum();
  }


  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.calculateColNum();
  }

  calculateColNum(){
    this.cols = window.innerWidth / 250 | 0;
  }

}
