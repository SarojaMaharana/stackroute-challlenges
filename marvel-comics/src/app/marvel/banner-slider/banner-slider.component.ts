import { Component, OnInit } from '@angular/core';
import { OwlOptions } from 'ngx-owl-carousel-o';

@Component({
  selector: 'app-banner-slider',
  templateUrl: './banner-slider.component.html',
  styleUrls: ['./banner-slider.component.css']
})
export class BannerSliderComponent implements OnInit {

  customOptions: OwlOptions = {
  loop: true,
    mouseDrag: false,
    touchDrag: false,
    pullDrag: false,
    dots: false,
    navSpeed: 700,
    navText: ['', ''],
    responsive: {
      0: {
        items: 1
      },
      400: {
        items: 1
      },
      740: {
        items: 1
      },
      940: {
        items: 1
      }
    },
    nav: true
  }

  imgBx:any
  slides:Array<any>
  i = 0
  constructor() { }
  
  ngOnInit(): void {
    // this.imgBx = document.querySelector('.imgBx')
    // this.slides = this.imgBx.getElementsByTagName('img')    
  }

  nextSlide() {
    this.slides[this.i].classList.remove('active')
    this.i = (this.i+1)%this.slides.length
    this.slides[this.i].classList.add('active')
  }

  previousSlide() {
    this.slides[this.i].classList.remove('active')
    this.i = (this.i-1+this.slides.length)%this.slides.length
    this.slides[this.i].classList.add('active')
  }

}
