import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AlternativeListComponent} from "./alternative-list/alternative-list/alternative-list.component";
import {DecisionTreeFormComponent} from "./decision-tree-form/decision-tree-form.component";

const routes: Routes = [
  {path: 'alternatives', component: AlternativeListComponent},
  {path: 'decisionTree', component: DecisionTreeFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
