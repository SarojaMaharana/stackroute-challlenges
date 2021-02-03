import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  displayedColumns: string[] = ['name_with_namespace', 'path_with_namespace', 'forks_count', 'star_count', 'open_issues_count', 'last_activity_at'];
  dataSource ;
  dataSourcePersonal ;
  value = '';

  URL = 'https://gitlab.stackroute.in/api/v4/projects'
  gitLabData: Array<any>
  userData: Array<any> = []

  constructor() { }

  ngOnInit(): void {
    this.loadData()
  }

  // loading the git data and making table data sources
  async loadData() {
    const response = await fetch(this.URL, {
      headers: {
        'Authorization': 'Bearer sonmDak6PABpgYXiDV6z'
      }
    })
    this.gitLabData = Array.of(await response.json())[0]
    this.dataSource = new MatTableDataSource(this.gitLabData)
    this.gitLabData.forEach(data => {
        if(data.namespace.name === 'mehersupreeth') {
          this.userData.push(data)
        }
    })
    this.dataSourcePersonal = new MatTableDataSource(this.userData)
    
  }
  grabTimeDifference(str: string) {
    var currentTime = new Date()
    var lastEditedTime = new Date(str)
    var diffValue = Math.ceil(Math.abs(currentTime.getTime() - lastEditedTime.getTime())/(1000*3600*24))
    if (diffValue <= 1) {
      return diffValue+ 'day ago'
    } else {
      return diffValue+' days ago'
    }
  }

}
