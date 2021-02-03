export class News {
    newsId: number;
    author: string;
    title: string;
    description: string;
    url: string;
    urlToImage: string;
    publishedAt: Date;
    content: string;
    newsSource: NewsSource;
    reminder: Reminder;
}
export class NewsSource {
    newsSourceId: number;
    newsSourceName: string;
    newsSourceDesc?: any;
    newsSourceCreatedBy?: any;
    newsSourceCreationDate: Date;
}
export class Reminder {
    reminderId: string;
    schedule: Date;
}