import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Category } from '../classes/category';
import { Music } from '../classes/music';
import { CommunicationService } from '../services/communication.service';

@Component({
  selector: 'app-add-music',
  templateUrl: './add-music.component.html',
  styleUrls: ['./add-music.component.css']
})
export class AddMusicComponent implements OnInit {

  categories: Array<Category> = [
    {categoryValue : 'artPunk', categoryName : 'Art Punk'},
    {categoryValue : 'alternativeRock', categoryName : 'Alternative Rock'},
    {categoryValue : 'britpunk', categoryName : 'Britpunk'},
    {categoryValue : 'collegeRock', categoryName : 'College Rock'},
    {categoryValue : 'crossoverThrash', categoryName : 'Crossover Thrash'},
    {categoryValue : 'crustPunk', categoryName : 'Crust Punk'},
    {categoryValue : 'emotionalHardcore', categoryName : 'Emotional Hardcore'},
    {categoryValue : 'experimentalRock', categoryName : 'Experimental Rock'},
    {categoryValue : 'folkPunk', categoryName : 'Folk Punk'},
    {categoryValue : 'goth', categoryName : 'Goth'},
    {categoryValue : 'grunge', categoryName : 'Grunge'},
    {categoryValue : 'hardcorePunk', categoryName : 'Hardcore Punk'},
    {categoryValue : 'hardRock', categoryName : 'Hard Rock'},
    {categoryValue : 'indieRock', categoryName : 'Indie Rock'},
    {categoryValue : 'lo-fi', categoryName : 'Lo-fi'},
    {categoryValue : 'musiqueConcrète', categoryName : 'Musique Concrète'}
  ];

  m: Music = new Music();
  nameBorderColor = '';
  nameDisplayStyle = 'none';
  categoryBorderColor = '';
  categoryDisplayStyle = 'none';
  @ViewChild('nameRef') nameElementRef: ElementRef;

  constructor(private communicationService: CommunicationService) { }

  ngOnInit(): void {
  }

  // onNameChange(event) {
  //   console.log(event.target.value);
  //   this.m.albumTitle = event.target.value;
  // }

  // onCategoryChange(event) {
  //   console.log(event.target.value);
  //   this.m.albumCategory = event.target.value;
  // }

  addMusicItem() {
    if ((this.m.albumCategory === '' || this.m.albumCategory === 'Choose...') && this.m.albumTitle === '') {
      this.categoryBorderColor = 'red';
      this.categoryDisplayStyle = '';
      this.nameBorderColor = 'red';
      this.nameDisplayStyle = '';
    }
    else if (this.m.albumCategory === '' || this.m.albumCategory === 'Choose...') {
      this.categoryBorderColor = 'red';
      this.nameBorderColor = '';
      this.categoryDisplayStyle = '';
      this.nameDisplayStyle = 'none';
    }
    else if (this.m.albumTitle === '') {
      this.categoryBorderColor = '';
      this.nameBorderColor = 'red';
      this.categoryDisplayStyle = 'none';
      this.nameDisplayStyle = '';
    }
    else {
      this.categoryBorderColor = '';
      this.nameBorderColor = '';
      this.categoryDisplayStyle = 'none';
      this.nameDisplayStyle = 'none';
      this.m.albumId = this.m.albumCategory + '_' + this.m.albumTitle;
      this.communicationService.addMusic(this.m)
      .subscribe(response => console.log('Added successfully'), error => console.log(error));
      this.communicationService.sendClickEvent();
      this.m = new Music();
      this.nameElementRef.nativeElement.focus();
    }
  }

}
