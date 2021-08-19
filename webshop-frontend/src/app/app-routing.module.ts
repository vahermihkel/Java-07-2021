import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';
import { ItemAddComponent } from './admin/item-add/item-add.component';
import { ItemEditComponent } from './admin/item-edit/item-edit.component';
import { ItemListComponent } from './admin/item-list/item-list.component';
import { CartComponent } from './cart/cart.component';
import { HomeComponent } from './home/home.component';
import { ViewItemComponent } from './home/view-item/view-item.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'ostukorv', component: CartComponent },
  { path: 'ese/:itemId', component: ViewItemComponent },
  { path: 'admin', component: AdminHomeComponent },
  { path: 'admin/lisa-ese', component: ItemAddComponent },
  { path: 'admin/muuda-ese/:itemId', component: ItemEditComponent },
  { path: 'admin/esemed', component: ItemListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
