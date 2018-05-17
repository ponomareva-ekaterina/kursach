import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {MatDialog} from '@angular/material';
import {ImageUploaderDialogComponent} from '../image-uploader-dialog/image-uploader-dialog.component';
import {FileHolder} from 'angular2-image-upload';

@Component({
  selector: 'app-image-uploader',
  templateUrl: './image-uploader.component.html',
  styleUrls: ['./image-uploader.component.css']
})
export class ImageUploaderComponent implements OnInit {

  mouseEnter: boolean = false;

  imgPlaceholderPath: string = `./assets/images/book-cover-placeholder.jpg`;

  @Output() imageEvent = new EventEmitter<FileHolder>();
  image: FileHolder;

  imgSrc: string;

  constructor(
    private uploaderDialog: MatDialog,
  ) { }

  ngOnInit() {
    this.imgSrc = this.imgPlaceholderPath;
  }

  imageUploaderDialog(){
    let dialogRef = this.uploaderDialog.open(
      ImageUploaderDialogComponent,

    );

    dialogRef.afterClosed().subscribe(
      result => {
        this.image = result;
        this.imgSrc = this.image.src;
        this.imageEvent.emit(this.image);
      }
    );
  }
}
