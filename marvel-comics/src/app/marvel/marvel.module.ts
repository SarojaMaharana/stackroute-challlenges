import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MarvelRoutingModule } from './marvel-routing.module';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { HttpClientModule } from '@angular/common/http';
import { MarvelComponent } from './marvel.component';
import { MarvelHomeComponent } from './marvel-home/marvel-home.component';
import { BannerSliderComponent } from './banner-slider/banner-slider.component';
import { MultiCarouselComponent } from './multi-carousel/multi-carousel.component';
import { MarvelService } from './services/marvel.service';
import { UsersService } from './services/users.service';
import { ToastrModule, ToastrService } from 'ngx-toastr';
import { MarvelNavigationComponent } from './marvel-navigation/marvel-navigation.component';
import { TestComponent } from './test/test.component';


@NgModule({
  declarations: [MarvelComponent, MarvelHomeComponent, BannerSliderComponent, MultiCarouselComponent, MarvelNavigationComponent, TestComponent],
  imports: [
    CommonModule,
    MarvelRoutingModule,
    CarouselModule,
    HttpClientModule,
    ToastrModule.forRoot()
  ],
  providers: [MarvelService, UsersService, ToastrService]
})
export class MarvelModule { }
