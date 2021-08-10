import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  toode1pealkiri = "toode1";
  toode1hind = 6;
  toode2pealkiri = "toode2";
  toode2hind = 8;

  tootePealkirjad = ["toode1", "toode2"];
  tooteHinnad = [6,8];

  toode1 = {pealkiri: "toode1", hind: 6};
  toode2 = {pealkiri: "toode2", hind: 8};

  tooted = [{pealkiri: "toode1", hind: 6},{pealkiri: "toode2", hind: 8}];

  items = [
    {title: "Toode1", price: 12, imgSrc: "", category: "book"},
    {title: "Toode2", price: 15, imgSrc: "", category: "book"},
    {title: "Toode3", price: 18, imgSrc: "", category: "book"},
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
