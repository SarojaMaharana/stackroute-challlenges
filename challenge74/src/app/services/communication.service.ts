import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Music } from '../classes/music';

@Injectable()
export class CommunicationService {

  commURL = 'http://localhost:3000/musicList';
  private subject = new Subject<any>();

  constructor(private httpClient: HttpClient) { }

  getMusicData() {
    return this.httpClient.get<Array<Music>>(this.commURL);
  }

  addMusic(music: Music) {
    return this.httpClient.post<Music>(this.commURL, music);
  }

  deleteMusic(id: number) {
    return this.httpClient.delete(this.commURL + `/${id}`);
  }

  sendClickEvent() {
    this.subject.next();
  }

  getClickEvent(): Observable<any> {
    return this.subject.asObservable();
  }
}
