import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MarvelHomeComponent } from './marvel-home/marvel-home.component';

import { MarvelComponent } from './marvel.component';
import { TestComponent } from './test/test.component';

// const routes: Routes = [{ path: '', component: MarvelComponent }];
const routes: Routes = [
  { 
    path: '',
    component: MarvelComponent,
    children: [
      {path: '', component: MarvelHomeComponent},
      { path: 'test', component: TestComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MarvelRoutingModule { }
