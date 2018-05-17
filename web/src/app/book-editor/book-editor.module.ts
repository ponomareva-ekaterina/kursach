import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EditBookComponent } from './edit-book/edit-book.component';
import {ReactiveFormsModule} from '@angular/forms';
import {
  MatAutocompleteModule,
  MatButtonModule, MatDatepickerModule,
  MatDialogModule,
  MatFormFieldModule,
  MatIconModule,
  MatInputModule, MatToolbarModule
} from '@angular/material';
import {SharedModule} from '../shared/shared.module';
import { NewAuthorDialogComponent } from './edit-book/new-author-dialog/new-author-dialog.component';
import {CdkTableModule} from '@angular/cdk/table';
import {MomentModule} from 'angular2-moment';
import { ImageUploaderComponent } from './edit-book/image-uploader/image-uploader.component';
import {ImageUploadModule} from 'angular2-image-upload';
import { ImageUploaderDialogComponent } from './edit-book/image-uploader-dialog/image-uploader-dialog.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatInputModule,
    MatFormFieldModule,
    SharedModule,
    MatDialogModule,
    MatAutocompleteModule,
    CdkTableModule,
    MatButtonModule,
    MatIconModule,
    MatDatepickerModule,
    MomentModule,
    MatToolbarModule,
    ImageUploadModule.forRoot(),
  ],
  exports: [
    EditBookComponent
  ],
  declarations: [EditBookComponent, NewAuthorDialogComponent, ImageUploaderComponent, ImageUploaderDialogComponent],
  entryComponents: [
    NewAuthorDialogComponent,
    ImageUploaderDialogComponent
  ]
})
export class BookEditorModule { }
