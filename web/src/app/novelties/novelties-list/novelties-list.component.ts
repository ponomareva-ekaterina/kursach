import { Component, OnInit } from '@angular/core';
import {NoveltiesListService} from './_services/novelties-list.service';

@Component({
  selector: 'app-novelties-list',
  templateUrl: './novelties-list.component.html',
  styleUrls: ['./novelties-list.component.css'],
  providers: [
    NoveltiesListService
  ]
})
export class NoveltiesListComponent implements OnInit {

  constructor(
    private noveltiesListService: NoveltiesListService
  ) { }

  ngOnInit() {
  }

}
