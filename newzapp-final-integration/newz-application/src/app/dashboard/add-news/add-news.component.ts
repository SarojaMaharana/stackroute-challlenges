import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { NewsService } from 'src/app/services/news.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-add-news',
  templateUrl: './add-news.component.html',
  styleUrls: ['./add-news.component.scss']
})
export class AddNewsComponent implements OnInit {

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

  constructor(private newsService: NewsService, private tokenService: TokenStorageService, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  async createNews() {
    this.newsItem.author = this.tokenService.getUser();
    await this.newsService.addNews(this.newsItem)
              .then(resp => {
                this.successMessage("Added Successfully");
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
