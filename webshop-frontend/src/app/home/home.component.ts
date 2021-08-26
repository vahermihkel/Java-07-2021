import { Component, OnInit } from '@angular/core';
import { Item } from '../models/item.model';
import { CartService } from '../services/cart.service';
import { ItemService } from '../services/item.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  // toode1pealkiri = "toode1";
  // toode1hind = 6;
  // toode2pealkiri = "toode2";
  // toode2hind = 8;

  // tootePealkirjad = ["toode1", "toode2"];
  // tooteHinnad = [6,8];

  // toode1 = {pealkiri: "toode1", hind: 6};
  // toode2 = {pealkiri: "toode2", hind: 8};

  // tooted = [{pealkiri: "toode1", hind: 6},{pealkiri: "toode2", hind: 8}];

  items: Item[] = [];

  // itemService: ItemService;

  constructor(private itemService: ItemService,
    private cartService: CartService) { 
    // this.itemService = _itemService;
  }

  ngOnInit(): void {
    console.log("olen home componendis");
    this.itemService.getItems().subscribe(itemsFromDb => {
      this.items = itemsFromDb;
    });
  }

  onAddToCart(item: Item) {
    this.cartService.addToCart(item);
  }
}
