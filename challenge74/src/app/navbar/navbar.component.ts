import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  navOffsetHeight: any;

  constructor() { }

  ngOnInit(): void {
    // let nav_offset_height = document.getElementById('header_area').offsetHeight + 50;
    this.navOffsetHeight = $('.header_area').height() + 50;
  }

  navbarFixed() {
    if(this.navOffsetHeight) {
      let scroll = $(window).scrollTop();
      if (scroll >= this.navOffsetHeight) {
        $('.header_area .main-menu').addClass('navbar_fixed');
      }
      else {
        $('.header_area .main-menu').removeClass('navbar_fixed');
      }
    }
  }

}
