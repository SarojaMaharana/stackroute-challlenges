import { Component, OnInit } from '@angular/core';
import { PlayerService } from './player.service';
import { Player } from 'src/model/Player';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  players: Player[] = [];
  player: Player = new Player();
  errorMessage: String = "";

  constructor(private playerService: PlayerService) { }


  ngOnInit() {
    this.getPlayersFromServer();
  }

  getPlayersFromServer() {
    // get the players by calling the appropriate PlayerService function
    // subscribe to the observable returned and assign the received players to the players array
    this.playerService.getPlayers().subscribe(res => {this.players=res})
  }

  newPlayer() {
     // newPlayer() will add the Player by calling the appropriate PlayerService function
  // if any of the form field is empty, set the errorMessage "Fields cannot be empty"
  // if the Player is added successfully,
  //    - update the Players array with the newly added player,
  //    - set the player to new player object
  //    - set the errorMessage to ""
  
    if (this.player.name == "" || this.player.country == "" || this.player.matchesPlayed == 0) {
      // add the required code here
      this.errorMessage = 'All fields a required'
    } else {
      // add the required code here
      this.errorMessage = ''
      this.players.push(this.player)
      this.playerService.addPlayer(this.player).subscribe(res => {console.log('player added')})
      this.player = new Player()
    }
  }

}
