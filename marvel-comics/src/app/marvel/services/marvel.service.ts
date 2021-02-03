import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const enum endpoint {
  characters = '/characters',
  comics = '/comics',
  creators = '/creators',
  events = '/events',
  series = '/series',
  stories = '/stories'
}

@Injectable({
  providedIn: 'root'
})
export class MarvelService {

  private URL = 'http://gateway.marvel.com/v1/public';
  private parameter = '?ts=1&apikey=e88608df52b7cd9a146502cde0e0f582&hash=fc3276ff9c37a3715cf3b7e9c578a4c1';

  constructor(private http: HttpClient) { }

  getAllComics(): Observable<any> {
    return this.http.get(this.URL+endpoint.comics+this.parameter);
  }

  getAllCharacters(): Observable<any> {
    return this.http.get(this.URL+endpoint.characters+this.parameter);
  }
  
  getAllCreators(): Observable<any> {
    return this.http.get(this.URL+endpoint.creators+this.parameter);
  }

  getAllEvents(): Observable<any> {
    return this.http.get(this.URL+endpoint.events+this.parameter);
  }

  getAllSeries(): Observable<any> {
    return this.http.get(this.URL+endpoint.series+this.parameter);
  }

  getAllStories(): Observable<any> {
    return this.http.get(this.URL+endpoint.stories+this.parameter);
  }
  
}
