import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BookList} from './book-list/book-list';
import { BookListItemComponent } from './book-list/book-list-item/book-list-item.component';
import { MatGridListModule} from '@angular/material';

@NgModule({
  imports: [
    CommonModule,
    MatGridListModule
  ],
  exports: [
    BookListItemComponent,
    BookList
  ],
  declarations: [BookListItemComponent, BookList]
})
export class SharedModule { }
