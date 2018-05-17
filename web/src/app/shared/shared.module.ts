import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BookListComponent} from './book-list/book-list.component';
import { BookListItemComponent } from './book-list/book-list-item/book-list-item.component';
import {MatButtonModule, MatFormFieldModule, MatGridListModule, MatIconModule, MatInputModule, MatToolbarModule} from '@angular/material';
import { PageHeaderComponent } from './page-header/page-header.component';
import {SpinnerModule} from 'angular2-spinner/dist';

@NgModule({
  imports: [
    CommonModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatFormFieldModule,
    MatToolbarModule,
    MatButtonModule,
    SpinnerModule
  ],
  exports: [
    BookListItemComponent,
    BookListComponent,
    PageHeaderComponent
  ],
  declarations: [BookListItemComponent, BookListComponent, PageHeaderComponent]
})
export class SharedModule { }
