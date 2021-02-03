import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { NewsService } from 'src/app/services/news.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-edit-news',
  templateUrl: './edit-news.component.html',
  styleUrls: ['./edit-news.component.scss']
})
export class EditNewsComponent implements OnInit {

  newsId: string;
  newsItem: any = {
    newsId: null,
    author: null,
    title: null,
    description: null,
    url: null,
    urlToImage: null,
    publishedAt: null,
    content: null,
    newsSource: {
      newsSourceId: null,
      newsSourceName: null,
      newsSourceDesc: null,
      newsSourceCreatedBy: null,
      newsSourceCreationDate: null
    },
    reminder: {
      reminderId: null,
      schedule: null
    }
  };

  constructor(private activatedRoute: ActivatedRoute, private newsService: NewsService, private tokenService: TokenStorageService, private toastr: ToastrService, private router: Router) { }

  ngOnInit(): void {
    this.newsId = this.activatedRoute.snapshot.params['id'];
    this.getNewsById()
  }

  async getNewsById() {
    await this.newsService.getNewsByNewsId(this.tokenService.getUser(), this.newsId)
              .then(resp => {
                this.newsItem = resp;
              })
              .catch(err => {
                this.failureMessage(err.error.message);
              });
  }

  async updateNews() {
    await this.newsService.updateNews(this.tokenService.getUser(), this.newsId, this.newsItem)
              .then(resp => {
                this.successMessage("Updated Successfully");
                this.router.navigate(['/news']);
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
