import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) { }

  getFavComics() {
    return this.http.get<Array<any>>('http://localhost:3000/comics')
  }

  getFavComicById(id) {
    return this.http.get('http://localhost:3000/comics/'+id)
  }

  deleteComicById(id) {
    return this.http.delete('http://localhost:3000/comics/'+id)
  }

  postFavComics(data: any) {
    return this.http.post('http://localhost:3000/comics', data)
  }

  getFavCharacters() {
    return this.http.get<Array<any>>('http://localhost:3000/characters')
  }

  deleteCharacterById (id) {
    return this.http.delete('http://localhost:3000/characters/'+id)
  }

  postFavCharacters(data: Array<any>) {
    return this.http.post('http://localhost:3000/characters', data)
  }

  getFavCreators() {
    return this.http.get<Array<any>>('http://localhost:3000/creators')
  }

  deleteCreatorById (id) {
    return this.http.delete('http://localhost:3000/creators/'+id)
  }

  postFavCreators(data: Array<any>) {
    return this.http.post('http://localhost:3000/creators', data)
  }

  getFavEvents() {
    return this.http.get<Array<any>>('http://localhost:3000/events')
  }

  deleteEventById (id) {
    return this.http.delete('http://localhost:3000/events/'+id)
  }

  postFavEvents(data: Array<any>) {
    return this.http.post('http://localhost:3000/events', data)
  }

  getFavSeries() {
    return this.http.get<Array<any>>('http://localhost:3000/series')
  }

  deleteSeriesById (id) {
    return this.http.delete('http://localhost:3000/series/'+id)
  }

  postFavSeries(data: Array<any>) {
    return this.http.post('http://localhost:3000/series', data)
  }
}
