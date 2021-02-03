import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddNewsComponent } from './add-news/add-news.component';

import { DashboardComponent } from './dashboard.component';
import { DisplayUserNewsComponent } from './display-user-news/display-user-news.component';
import { EditNewsComponent } from './edit-news/edit-news.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

const routes: Routes = [
  { 
    path: '',
    component: DashboardComponent,
    children: [
      {
        path: '',
        component: DisplayUserNewsComponent
      },
      {
        path: 'user-profile',
        component: UserProfileComponent
      },
      {
        path: 'add-news',
        component: AddNewsComponent
      },
      {
        path: 'edit-news/:id',
        component: EditNewsComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
