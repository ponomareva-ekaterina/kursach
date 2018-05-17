import {Component, ElementRef} from '@angular/core';
import {Router} from '@angular/router';
import {ResizedEvent} from 'angular-resize-event/dist/resized-event';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  headerHeight: number;

  contentHeight: number;

  constructor(private router: Router) {
  }

  redirectToNew(){
    this.router.navigate(['new']);
  }

  redirectToBookShop(){
    this.router.navigate(['books']);
  }

  onResize(event: ResizedEvent){
    this.contentHeight = event.newHeight - this.headerHeight;
  }

  onHeaderResize(event: ResizedEvent){
    this.headerHeight = event.newHeight;
  }
    redirectToAddNewBook(){
      this.router.navigate(['edit/book/new']);
    }


}
