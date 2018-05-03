import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {SharedModule} from './shared/shared.module';
import {
  MatButtonModule, MatFormFieldModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatSidenavModule,
  MatToolbarModule
} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {routing} from './app.routing';
import {NoveltiesModule} from './novelties/novelties.module';
import {BookShopModule} from './book-shop/book-shop.module';
import {AngularResizedEventModule} from 'angular-resize-event/dist';
import {BookEditorModule} from './book-editor/book-editor.module';


@NgModule({
  imports: [
    BrowserModule,
    SharedModule,
    MatIconModule,
    MatListModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatButtonModule,
    MatMenuModule,
    NoveltiesModule,
    BookShopModule,
    AngularResizedEventModule,
    MatInputModule,
    MatFormFieldModule,
    MatIconModule,
    BookEditorModule,
    routing
  ],
  declarations: [
    AppComponent,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
