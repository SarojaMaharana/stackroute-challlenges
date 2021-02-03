import { Component, OnInit } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/auth';
import { Router } from '@angular/router';
import { MarvelService } from '../services/marvel.service';

@Component({
  selector: 'app-marvel-home',
  templateUrl: './marvel-home.component.html',
  styleUrls: ['./marvel-home.component.css']
})
export class MarvelHomeComponent implements OnInit {

  comics: Array<any>;
  characters: Array<any>;
  creators: Array<any>;
  events: Array<any>;
  series: Array<any>;
  stories: Array<any>;

  constructor(private marvel: MarvelService) { }

  ngOnInit(): void {
    this.marvel.getAllComics().subscribe(res => {
      this.comics = res.data.results
    })
    this.marvel.getAllCharacters().subscribe(res => {
      this.characters = res.data.results
    })
    this.marvel.getAllCreators().subscribe(res => {
      this.creators = res.data.results
    })
    this.marvel.getAllEvents().subscribe(res => {
      this.events = res.data.results
    })
    this.marvel.getAllSeries().subscribe(res => {
      this.series = res.data.results
    })
    // this.marvel.getAllStories().subscribe(res => {
    //   this.stories = res.data.results
    // })
  }
}
