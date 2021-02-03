import { TestBed, async, ComponentFixture } from '@angular/core/testing';
import { AppComponent } from '../src/app/app.component';
import { HeaderComponent } from 'src/app/header/header.component';
import { PlayerService } from 'src/app/player.service';
import { FormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from 'rxjs';

describe('AppComponent', () => {

  let fixture: ComponentFixture<AppComponent>;
  let service: any;

  beforeEach(async(() => {

    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        HeaderComponent
      ],
      imports: [
        FormsModule,
        HttpClientTestingModule
      ],
      providers: [PlayerService]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppComponent);
    service = TestBed.get(PlayerService);
  })

  it('should be created', () => {

    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });


  it('should render app-header', () => {
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('.navbar-brand')).not.toBeNull("App Component must contain '<app-header></app-header>'");
  });


  it('should contain a submit button with the text "Add Player"', () => {
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('.btn').textContent).toBe("Add Player", "Must contain '<button type=\"submit\" class=\"btn btn-primary\">Add Player</button>'");
  });

  it("getPlayersFromServer() should fetch players by calling getPlayers() of PlayerService", () => {
    const compiled = fixture.debugElement.componentInstance;
    spyOn(service, "getPlayers").and.returnValue(of(1));
    compiled.getPlayersFromServer();
    expect(service.getPlayers).toHaveBeenCalled();
    expect(service.getPlayers).toHaveBeenCalledTimes(1);
  })

  it("when all the fields of a player to be added is provided, newPlayer() should add a new player by calling addPlayer() of PlayerService", () => {
    const compiled = fixture.debugElement.componentInstance;
    spyOn(service, "addPlayer").and.returnValue(of(1));
    compiled.player = { name: "Shewag", country: "India", matchesPlayed: 200 };
    compiled.newPlayer();
    expect(service.addPlayer).toHaveBeenCalled();
    expect(service.addPlayer).toHaveBeenCalledTimes(1);
  })

  it("when any of the field of the Player to be added is missing, newPlayer() should not call addPlayer()", () => {
    const compiled = fixture.debugElement.componentInstance;
    spyOn(service, "addPlayer").and.returnValue(of(1));
    compiled.player = { name: "", country: "", matchesPlayed: 0 };
    compiled.newPlayer();
    expect(service.addPlayer).toHaveBeenCalledTimes(0);
  })
});
