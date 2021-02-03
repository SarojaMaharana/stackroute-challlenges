import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Music } from '../classes/music';
import { CommunicationService } from '../services/communication.service';

@Component({
  selector: 'app-display-music',
  templateUrl: './display-music.component.html',
  styleUrls: ['./display-music.component.css']
})
export class DisplayMusicComponent implements OnInit {

  clickEventSubscription: Subscription;
  mList: Array<Music> = [];
  counter = 0;
  url = 'http://localhost:3000/musicList/';

  constructor(private communicationService: CommunicationService) {
    // this.clickEventSubscription = communicationService.getClickEvent().subscribe(() => {
      // this.increment();
      // this.displayMusic();
    // });
  }

  ngOnInit() {
    this.displayMusic();
  }

  openView(id) {
    window.open(this.url + id);
  }

  increment() {
    this.counter++;
  }

  displayMusic(){
    this.communicationService.getMusicData()
    .subscribe(response => {
      this.mList = response;
    }, error => console.log(error));
  }

  deleteMusic(id: number) {
    this.communicationService.deleteMusic(id)
    .subscribe(response => {
      const musicIndex = this.findMusicIndex(id);
      this.mList.splice(musicIndex, 1);
      this.displayMusic();
    }, error => console.log(error));
  }

  findMusicIndex(id: number) {
    for (let i = 0; i < this.mList.length; i++){
      if (id === this.mList[i].id) {
        return i;
      }
    }
  }

}
