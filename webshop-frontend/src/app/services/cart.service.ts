import { Injectable } from '@angular/core';
import { Item } from '../models/item.model';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private cartItems: Item[] = [];

  constructor() { }

  // this.cartService.cartItems.push(item); -- cartItems otse on ligipääsmatu
  // this.cartService.addToCart(item);
  addToCart(item: Item) {
    this.cartItems.push(item);
  }

  // this.cartService.cartItems
  // this.cartService.getItems();
  getCartItems() {
    return this.cartItems.slice();    // mälukoha teema
  }

  // this.cartService.cartItems = [];
  // this.cartService.emptyCart();
  emptyCart() {
    this.cartItems = [];
  }

  // this.cartService.cartItems.indexOf(item)
  // this.cartService.cartItems.splice(index,1)

  // this.cartService.removeFromCart(item);
  removeFromCart(item: Item) {
    let index = this.cartItems.indexOf(item);
    this.cartItems.splice(index,1);
  }
}
