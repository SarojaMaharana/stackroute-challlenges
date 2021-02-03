import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { NewsService } from 'src/app/services/news.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-display-user-news',
  templateUrl: './display-user-news.component.html',
  styleUrls: ['./display-user-news.component.scss']
})
export class DisplayUserNewsComponent implements OnInit {

  newsList: Array<any>;

  constructor(private newsService: NewsService, private toastr: ToastrService, private tokenService: TokenStorageService) { }

  ngOnInit(): void {
    this.getAllNewsByUser();
  }

  async getAllNewsByUser() {
    await this.newsService.getNewsByUserId(this.tokenService.getUser())
              .then(resp => {
                this.newsList = resp;
              })
              .catch(error => {
                this.failureMessage(error.error.message);
              })
  }

  async deleteNews(id: string) {
    await this.newsService.deleteNewsById(this.tokenService.getUser(), id)
              .then(resp => {
                this.getAllNewsByUser();
                this.successMessage("Deleted Successfully");
              })
              .catch(err => {
                this.failureMessage(err.error.message);
              });
  }

  successMessage(message: string) {
    this.toastr.success(message);
  }

  failureMessage(message: string) {
    this.toastr.error(message);
  }

}
