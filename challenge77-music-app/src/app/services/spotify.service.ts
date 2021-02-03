import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SpotifyService {

  tokenHeader: HttpHeaders = new HttpHeaders({
    'Authorization': 'Bearer BQCMYgv5eOOZlw717w7IDqnY6RqAw9Boa9k7b-tyPB-UztTNQ6XmsiMs0a3mIF03JJjepM5Ex5MxI4f5KczywhXEEVi2yY5RRlkdZ65caXo-AAVgoa-eAxB4ueuTbWdVeV5VCYJRbeOqxBMN29f-GdYq6ufPG_PxQrw7OyQxJnw6eMqYARlESuxTnAAdFTUjzSXy1EqDebZEiHJJhpP3YhRFX7E3I77tqVjnvBqfubceTJGh8-2oNuwgX4Z3veQ_4zeerLYP_nGVErBa2R8HZBZ0vodtm-qdVPg'
  });

  constructor( private http: HttpClient) { }

  getNewReleases () {
    return this.http.get('https://api.spotify.com/v1/browse/new-releases?country=IN', {headers: this.tokenHeader});
  }

  getFeauredPlayLists () {
    return this.http.get('https://api.spotify.com/v1/browse/featured-playlists?country=IN', {headers: this.tokenHeader});
  }

  getCategories () {
    return this.http.get('https://api.spotify.com/v1/browse/categories?country=IN', {headers: this.tokenHeader});
  }

  // getAvaliableGenreSeeds () {
  //   return this.http.get('https://api.spotify.com/v1/recommendations/available-genre-seeds', {headers: this.tokenHeader});
  // }

  getAlbumsTracks (id) {
    return this.http.get('https://api.spotify.com/v1/albums/'+id+'/tracks', {headers: this.tokenHeader});
  }

  getAlbumDetails (id) {
    return this.http.get('https://api.spotify.com/v1/albums/'+id, {headers: this.tokenHeader});
  }

  getPlaylist (id) {
    return this.http.get('https://api.spotify.com/v1/playlists/'+id, {headers: this.tokenHeader});
  }

  getCategoryItem (id) {
    return this.http.get('https://api.spotify.com/v1/browse/categories/'+id, {headers: this.tokenHeader});
  }

  getCategoryPlaylists(id) {
    return this.http.get('https://api.spotify.com/v1/browse/categories/'+id+'/playlists', {headers: this.tokenHeader});
  }
}
