import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BookList} from './book-list/book-list';
import { BookListItemComponent } from './book-list/book-list-item/book-list-item.component';
import {MatButtonModule, MatFormFieldModule, MatGridListModule, MatIconModule, MatInputModule, MatToolbarModule} from '@angular/material';
import { PageHeaderComponent } from './page-header/page-header.component';

@NgModule({
  imports: [
    CommonModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatFormFieldModule,
    MatToolbarModule,
    MatButtonModule
  ],
  exports: [
    BookListItemComponent,
    BookList,
    PageHeaderComponent
  ],
  declarations: [BookListItemComponent, BookList, PageHeaderComponent]
})
export class SharedModule { }
