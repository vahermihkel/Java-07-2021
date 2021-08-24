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
  sumOfCart = 0;

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.cartItems = this.cartService.getCartItems();
    this.calculateSumOfCart();
  }

  onEmptyCart() {
    // this.cartService.cartItems.splice(0);
    this.cartService.emptyCart();
    this.cartItems = this.cartService.getCartItems();
    this.calculateSumOfCart();
  }

  onRemoveFromCart(item: Item) {
    // let index = this.cartService.cartItems.findIndex(cartItem => cartItem.title == _item.title);
    this.cartService.removeFromCart(item);
    this.cartItems = this.cartService.getCartItems();
    this.calculateSumOfCart();
  }

  private calculateSumOfCart() {
    this.sumOfCart = 0;
    this.cartItems.forEach(cartItem => {
      this.sumOfCart += cartItem.price;
    });
    
    // 10 = 0 + 10;
    // 24 = 10 + 14;

    // *ngFor="let cartItem of cartItems"
    // {{ cartItem }}


    // for(Item cartItem: cartItems) {

    //}
  }

}
