import { Component, OnInit } from '@angular/core';
import { Item } from '../models/item.model';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartItems: Item[] = [];

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.cartItems = this.cartService.getCartItems();
  }

  onEmptyCart() {
    // this.cartService.cartItems.splice(0);
    this.cartService.emptyCart();
    this.cartItems = this.cartService.getCartItems();
  }

  onRemoveFromCart(item: Item) {
    // let index = this.cartService.cartItems.findIndex(cartItem => cartItem.title == _item.title);
    this.cartService.removeFromCart(item);
    this.cartItems = this.cartService.getCartItems();
  }

}
