import {Component, Input, OnInit} from '@angular/core';
import {BookModel} from '../../../book-editor/edit-book/_models/book.model';
import {Router} from '@angular/router';
import {BookCoverService} from './_service/book-cover.service';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-book-list-item',
  templateUrl: './book-list-item.component.html',
  styleUrls: ['./book-list-item.component.css'],
  providers: [
    BookCoverService
  ]
})
export class BookListItemComponent implements OnInit {

  mouseEnter: boolean = false;

  imgPlaceholderPath: string = `./assets/images/book-cover-placeholder.jpg`;
  img: string = this.imgPlaceholderPath;

  @Input()
  item: BookModel;

  constructor(
    private router: Router,
    private bookCoverService: BookCoverService,
    private domSanitizer: DomSanitizer
  ) { }

  ngOnInit() {
    this.bookCoverService.get(this.item.id, this.item.author.id).subscribe(
      response => {
        if(response && response.base64 !== ''){
          this.img = response.base64;
        }
      }
    );
  }

  redirectToEditBook(){
    this.router.navigate(['edit/book/' + this.item.id]);
  }
}
