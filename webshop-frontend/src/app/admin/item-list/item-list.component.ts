import { Component, OnInit } from '@angular/core';
import { ItemService } from 'src/app/services/item.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {
  items: {title: string, imgSrc: string, price: number, category: string}[] = [];

  constructor(private itemService: ItemService) { }

  ngOnInit(): void {
    this.items = this.itemService.itemsInService;
  }

}
