import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {NewAuthorDialogComponent} from '../new-author-dialog/new-author-dialog.component';

@Component({
  selector: 'app-image-uploader-dialog',
  templateUrl: './image-uploader-dialog.component.html',
  styleUrls: ['./image-uploader-dialog.component.css']
})
export class ImageUploaderDialogComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<NewAuthorDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data
  ) { }

  ngOnInit() {
  }

  onNoClick(data?): void {
    this.dialogRef.close(data);
  }

  getImage(event){
    this.onNoClick(event)
  }

}
