import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { CartComponent } from './cart/cart.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ItemAddComponent } from './admin/item-add/item-add.component';
import { ItemListComponent } from './admin/item-list/item-list.component';
import { ItemEditComponent } from './admin/item-edit/item-edit.component';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CartComponent,
    NavbarComponent,
    ItemAddComponent,
    ItemListComponent,
    ItemEditComponent,
    AdminHomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
