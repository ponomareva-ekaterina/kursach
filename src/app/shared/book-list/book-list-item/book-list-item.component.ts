import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-book-list-item',
  templateUrl: './book-list-item.component.html',
  styleUrls: ['./book-list-item.component.css']
})
export class BookListItemComponent implements OnInit {

  mouseEnter: boolean = false;

  imgPlaceholderPath: string;

  constructor() { }

  ngOnInit() {
    this.imgPlaceholderPath = `./assets/images/book-cover-placeholder.jpg`;
  }

}
