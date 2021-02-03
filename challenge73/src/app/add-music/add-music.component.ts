import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { CategoryModule } from '../modules/category/category.module';
import { MusicModule } from '../modules/music/music.module'
import { SiblingCommunicationService } from '../services/sibling-communication.service';

@Component({
  selector: 'app-add-music',
  templateUrl: './add-music.component.html',
  styleUrls: ['./add-music.component.css']
})
export class AddMusicComponent implements OnInit {

  categories: Array<CategoryModule> = [
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
  m: MusicModule = new MusicModule();
  mList: Array<MusicModule> = [];
  nameBorderColor = '';
  nameDisplayStyle = 'none';
  categoryBorderColor = '';
  categoryDisplayStyle = 'none';
  @ViewChild('nameRef') nameElementRef: ElementRef;

  tempMsg = 'Hello MSG from add-music components';

  constructor( private siblingCommunicationService: SiblingCommunicationService) { }

  ngOnInit(): void {
  }

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
      this.mList.push(this.m);
      this.siblingCommunicationService.communicateMessage(this.m);
      this.m = new MusicModule();
      this.nameElementRef.nativeElement.focus();
    }
  }

  sendInfoToDisplay() {
  }

}
