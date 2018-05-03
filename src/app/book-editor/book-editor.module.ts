import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EditBookComponent } from './edit-book/edit-book.component';

@NgModule({
  imports: [
    CommonModule
  ],
  exports: [
    EditBookComponent
  ],
  declarations: [EditBookComponent]
})
export class BookEditorModule { }
