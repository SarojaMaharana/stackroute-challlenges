import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardComponent } from './dashboard.component';
import { HeaderComponent } from './header/header.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { FooterComponent } from './footer/footer.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor, authInterceptorProviders } from '../interceptor/auth.interceptor';
import { FormsModule } from '@angular/forms';
import { DisplayUserNewsComponent } from './display-user-news/display-user-news.component';
import { EditNewsComponent } from './edit-news/edit-news.component';
import { AddNewsComponent } from './add-news/add-news.component';


@NgModule({
  declarations: [
    DashboardComponent, 
    HeaderComponent, 
    UserProfileComponent, 
    FooterComponent, DisplayUserNewsComponent, EditNewsComponent, AddNewsComponent],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    FormsModule
  ]
  // providers: [authInterceptorProviders]
})
export class DashboardModule { }
