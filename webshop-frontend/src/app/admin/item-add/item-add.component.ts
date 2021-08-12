import { Component, OnInit } from '@angular/core';
import { ItemService } from 'src/app/services/item.service';

@Component({
  selector: 'app-item-add',
  templateUrl: './item-add.component.html',
  styleUrls: ['./item-add.component.css']
})
export class ItemAddComponent implements OnInit {

  constructor(private itemService: ItemService) { }

  ngOnInit(): void {
  }

  onAddNewItem() {
    console.log("töötab");
    this.itemService.itemsInService.push(
      { 
        imgSrc: "string", 
        title: "string", 
        price: 190, 
        category: "string" 
      });
  }
}
