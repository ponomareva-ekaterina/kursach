import {Component, HostListener, OnInit} from '@angular/core';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.html',
  styleUrls: ['./book-list.css']
})
export class BookList implements OnInit {

  i = [
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
    {
      index: 1
    },
  ];

  cols: number = 1;

  constructor() { }

  ngOnInit() {
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
