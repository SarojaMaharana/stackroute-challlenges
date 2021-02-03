import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { TokenStorageService } from './token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  tokenHeader: HttpHeaders = new HttpHeaders({
    'Authorization': `Bearer ${this.tokenService.getToken()}`
  });

  constructor(private http: HttpClient, private tokenService: TokenStorageService) { }

  getAllNews() {
    return this.http.get<any>(environment.allNewsUrl).toPromise();
  }

  getNewsByUserId(userId: string) {
    return this.http.get<any>(environment.newsServiceUrl+userId, {headers: this.tokenHeader}).toPromise();
  }

  deleteNewsById(userId: string, newsId: string) {
    return this.http.delete<any>(`${environment.newsServiceUrl}${userId}/${newsId}`, {headers: this.tokenHeader}).toPromise();
  }

  getNewsByNewsId(userId: string, newsId: string) {
    return this.http.get<any>(`${environment.newsServiceUrl}${userId}/${newsId}`, {headers: this.tokenHeader}).toPromise();
  }

  updateNews(userId: string, newsId: string, news: any) {
    return this.http.put<any>(`${environment.newsServiceUrl}${userId}/${newsId}`, news, {headers: this.tokenHeader}).toPromise();
  }

  addNews(news: any) {
    return this.http.post<any>(environment.newsServiceUrl, news, {headers: this.tokenHeader}).toPromise();
  }
}
