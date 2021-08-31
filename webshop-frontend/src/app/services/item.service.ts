import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Item } from '../models/item.model';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  private itemsInService: Item[] = [];

  constructor(public http: HttpClient) { }

  addItem(item: Item) {
    return this.http.post("http://localhost:8080/add-item", item);
  }

  getItems() {
    return this.http.get<Item[]>("http://localhost:8080/items");
  }

  removeItem(item: Item) {
    return this.http.delete("http://localhost:8080/delete-item/" + item.id);
  }

  getItem(id: string) {
    return this.http.get<Item>("http://localhost:8080/view-item/" + id);
  }

  editItem(item: Item) {
    return this.http.post("http://localhost:8080/edit-item", item);
  }
}
