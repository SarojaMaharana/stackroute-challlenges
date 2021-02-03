import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SiblingCommunicationService {
  sendMessage = new Subject();

  constructor() { }

  communicateMessage(msg) {
    this.sendMessage.next(msg);
  }
}
