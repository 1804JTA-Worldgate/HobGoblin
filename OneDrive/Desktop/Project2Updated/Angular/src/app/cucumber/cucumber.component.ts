import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/catch';

@Component({
  selector: 'app-cucumber',
  templateUrl: './cucumber.component.html',
  styleUrls: ['./cucumber.component.css']
})
export class CucumberComponent implements OnInit {
  constructor(private http: HttpClient) {
  } 
  ngOnInit() {
  }
  runCucumber(): void {
    this.http.post('http://localhost:8080/ServletAngular/runCucumber.do', {
    }).subscribe(
      res => {
      console.log(res);
    }
  );
  }
}
