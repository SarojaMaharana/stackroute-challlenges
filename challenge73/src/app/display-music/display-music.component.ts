import { Component, OnInit } from '@angular/core';
import { MusicModule } from '../modules/music/music.module';
import { SiblingCommunicationService } from '../services/sibling-communication.service';

@Component({
  selector: 'app-display-music',
  templateUrl: './display-music.component.html',
  styleUrls: ['./display-music.component.css']
})
export class DisplayMusicComponent implements OnInit {

  mList: Array<MusicModule> = [];
  mItem: MusicModule = new MusicModule() ;
  temp;

  constructor(private siblingCommunicationService: SiblingCommunicationService) { }

  ngOnInit(): void {
    this.siblingCommunicationService.sendMessage.subscribe(musicObject => {
      this.mItem.albumId = Object.values(musicObject)[0];
      this.mItem.albumTitle = Object.values(musicObject)[1];
      this.mItem.albumCategory = Object.values(musicObject)[2];
      this.mList.push(this.mItem);
      this.mItem = new MusicModule();
    });
  }

}
