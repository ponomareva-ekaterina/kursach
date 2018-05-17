import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-new-author-dialog',
  templateUrl: './new-author-dialog.component.html',
  styleUrls: ['./new-author-dialog.component.css']
})
export class NewAuthorDialogComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<NewAuthorDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: FormGroup,
    @Inject(FormBuilder) private fb: FormBuilder
  ) { }

  ngOnInit() {
    this.data = this.fb.group({
      id: -1,
      firstName: '',
      lastName: '',
      middleName: ''
    });
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
