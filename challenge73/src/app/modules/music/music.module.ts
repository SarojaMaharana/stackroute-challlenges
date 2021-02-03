import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class MusicModule {
  albumId = '';
  albumTitle = '';
  albumCategory = 'Choose...';

  // constructor(id: string, title: string, category: string){
  //   this.albumId = id;
  //   this.albumTitle = title;
  //   this.albumCategory = category;
  // }
}
