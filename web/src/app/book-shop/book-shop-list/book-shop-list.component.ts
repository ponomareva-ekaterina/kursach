import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-book-shop-list',
  templateUrl: './book-shop-list.component.html',
  styleUrls: ['./book-shop-list.component.css']
})
export class BookShopListComponent implements OnInit {

  filterParams: FormGroup;

  constructor(@Inject(FormBuilder) private fb: FormBuilder,) { }

  ngOnInit() {
    this.filterParams = this.fb.group({

    });
  }

}
