import { TestBed, async, } from '@angular/core/testing';
import { PlayerService } from 'src/app/player.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpClient } from '@angular/common/http';
import { of } from 'rxjs';

describe('playerService', () => {

    let service: any;
    let http: any;

    beforeEach(async(() => {

        TestBed.configureTestingModule({
            imports: [HttpClientTestingModule],
            providers: [HttpClient]
        }).compileComponents();
    }));

    beforeEach(() => {
        service = TestBed.get(PlayerService);
        http = TestBed.get(HttpClient);
    })

    it('should be created', () => {

        expect(service).toBeTruthy();
    });

    it('getPlayers() should call get() of HttpClient', () => {

        spyOn(http, "get").and.returnValue(of(1));
        service.getPlayers();
        expect(http.get).toHaveBeenCalled();
        expect(http.get).toHaveBeenCalledTimes(1);
    })

    it('addPlayer() should call post() of HttpClient', () => {

        spyOn(http, "post").and.returnValue(of(1));
        service.addPlayer();
        expect(http.post).toHaveBeenCalled();
        expect(http.post).toHaveBeenCalledTimes(1);
    })

});
