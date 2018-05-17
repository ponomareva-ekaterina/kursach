import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BookShopListComponent } from './book-shop-list/book-shop-list.component';
import {SharedModule} from '../shared/shared.module';
import {MatExpansionModule, MatFormFieldModule, MatIconModule, MatInputModule} from '@angular/material';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    MatExpansionModule,
    MatInputModule,
    MatFormFieldModule,
    MatIconModule,
    ReactiveFormsModule,

  ],
  exports: [
    BookShopListComponent
  ],
  declarations: [BookShopListComponent]
})
export class BookShopModule { }
