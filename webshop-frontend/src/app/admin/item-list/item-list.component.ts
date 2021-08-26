import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/models/item.model';
import { ItemService } from 'src/app/services/item.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {
  items: Item[] = [];

  constructor(private itemService: ItemService) { }

  ngOnInit(): void {
    this.itemService.getItems().subscribe(itemsFromDb => {
      this.items = itemsFromDb;
    });
  }

  onRemoveItem(item: Item) {
    this.itemService.removeItem(item).subscribe(() => {
      this.itemService.getItems().subscribe(itemsFromDb => {
        this.items = itemsFromDb;
      });
    });
  }
}
