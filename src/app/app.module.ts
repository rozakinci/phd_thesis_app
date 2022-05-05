import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AlternativeService} from "./service/alternative.service";
import {AlternativeListComponent} from './alternative-list/alternative-list/alternative-list.component';
import {HttpClientModule} from "@angular/common/http";
import {DecisionTreeFormComponent} from "./decision-tree-form/decision-tree-form.component";
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";

@NgModule({
  declarations: [
    AppComponent,
    AlternativeListComponent,
    DecisionTreeFormComponent

  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AlternativeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
