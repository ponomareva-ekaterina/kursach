import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {SharedModule} from '../shared/shared.module';
import {MatGridListModule} from '@angular/material';
import { NoveltiesListComponent } from './novelties-list/novelties-list.component';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
  ],
  exports: [

  ],
  declarations: [NoveltiesListComponent]
})
export class NoveltiesModule { }
