import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Player } from 'src/model/Player';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http: HttpClient) { }

  getPlayers(): Observable<Player[]> {
    // perform the appropriate API call here that will get the players from the server
    return this.http.get<Player[]>('http://localhost:3000/players')
  }

  addPlayer(player: Player): Observable<Player> {
    // perform the appropriate API call here that will add a player to the server
    return this.http.post<Player>('http://localhost:3000/players', player);
  }
}

