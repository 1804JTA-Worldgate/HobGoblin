import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { HttpRequest } from '@angular/common/http';
@Component({
  selector: 'app-jasmine',
  templateUrl: './jasmine.component.html',
  styleUrls: ['./jasmine.component.css']
})
export class JasmineComponent implements OnInit {

  constructor(private http: HttpClient) {}

  ngOnInit() {
  }
  runCucumber(): void {
    this.http.post('http://localhost:8080/ServletAngular/runCucumber.do', {
    }).subscribe(res => {
      console.log(res);
    });
  }
}
