import { Component, Input, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { OwlOptions } from 'ngx-owl-carousel-o';
import { ToastrService } from 'ngx-toastr';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-multi-carousel',
  templateUrl: './multi-carousel.component.html',
  styleUrls: ['./multi-carousel.component.css']
})
export class MultiCarouselComponent implements OnInit {

  @Input() title: string
  @Input() dataList: Array<any>
  ids: Array<number> = []
  customOptions: OwlOptions = {
    loop: true,
    mouseDrag: true,
    touchDrag: true,
    pullDrag: false,
    dots: false,
    navSpeed: 700,
    navText: ['', ''],
    responsive: {
      0: {
        items: 1
      },
      400: {
        items: 2
      },
      740: {
        items: 4
      },
      940: {
        items: 5
      }
    },
    nav: true
  }

  constructor(private user: UsersService, private toastr: ToastrService) { }

  ngOnInit(): void {
    switch (this.title) {
      case 'Comics':  this.user.getFavComics().subscribe(res => {
                        res.forEach(r => this.ids.push(r.id))
                      })
                      break
      case 'Characters':  this.user.getFavCharacters().subscribe(res => {
                            res.forEach(r => this.ids.push(r.id))
                          })
                          break
      case 'Creators':  this.user.getFavCreators().subscribe(res => {
                          res.forEach(r => this.ids.push(r.id))
                        })
                        break
      case 'Events':  this.user.getFavEvents().subscribe(res => {
                            res.forEach(r => this.ids.push(r.id))
                          })
                      break
      case 'Series':  this.user.getFavSeries().subscribe(res => {
                            res.forEach(r => this.ids.push(r.id))
                          })
                      break
      default: console.log('default')
    }
  }

  addToFavorites(item: any) {
    switch (this.title) {
      case 'Comics':      if (this.ids.find((n) => n===item['id'])) {
                            this.ids = this.ids.filter(e => e!==item.id)
                            this.user.deleteComicById(item.id).subscribe(res => {
                              // this.toastr.warning(`${item['title']} already exists in favorites`)
                              this.toastr.error(`${item['title']} removed from favorites`)
                            })
                          }
                          else {
                            this.ids.push(item.id)
                            this.user.postFavComics(item).subscribe(res => {
                              this.toastr.success(`${item['title']} added to favorites`)
                            })
                          }
                          break
      case 'Characters':  if (this.ids.find((n) => n===item['id'])) {
                            this.ids = this.ids.filter(e => e!==item.id)
                            this.user.deleteCharacterById(item.id).subscribe( res => {
                              this.toastr.error(`${item['name']} removed from favorites`)
                            })
                          }
                          else {
                            this.ids.push(item.id)
                            this.user.postFavCharacters(item).subscribe(res => {
                              this.toastr.success(`${item['name']} added to favorites`)
                            })
                          }
                          break
      case 'Creators':    if (this.ids.find((n) => n===item['id'])) {
                            this.ids = this.ids.filter(e => e!==item.id)
                            this.user.deleteCreatorById(item.id).subscribe(res => {
                              this.toastr.error(`${item['fullName']} removed from favorites`)
                            })
                          }
                          else {
                            this.ids.push(item.id)
                            this.user.postFavCreators(item).subscribe(res => {
                              this.toastr.success(`${item['fullName']} added to favorites`)
                            })
                          }
                          break
      case 'Events':    if (this.ids.find((n) => n===item['id'])) {
                          this.ids = this.ids.filter(e => e!==item.id)
                          this.user.deleteEventById(item.id).subscribe(res => {
                            this.toastr.error(`${item['title']} removed from favorites`)
                          })
                        }
                        else {
                          this.ids.push(item.id)
                          this.user.postFavEvents(item).subscribe(res => {
                            this.toastr.success(`${item['title']} added to favorites`)
                          })
                        }
                        break
      case 'Series':    if (this.ids.find((n) => n===item['id'])) {
                          this.ids = this.ids.filter(e => e!==item.id)
                          this.user.deleteSeriesById(item.id).subscribe(res => {
                            this.toastr.error(`${item['title']} removed from favorites`)
                          })
                        }
                        else {
                          this.ids.push(item.id)
                          this.user.postFavSeries(item).subscribe(res => {
                            this.toastr.success(`${item['title']} added to favorites`)
                          })
                        }
                        break
      default: console.log('default')
    }
  }

}
