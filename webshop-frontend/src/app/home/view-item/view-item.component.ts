import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Item } from 'src/app/models/item.model';
import { ItemService } from 'src/app/services/item.service';

@Component({
  selector: 'app-view-item',
  templateUrl: './view-item.component.html',
  styleUrls: ['./view-item.component.css']
})
export class ViewItemComponent implements OnInit {
  item!: Item;

  constructor(private route: ActivatedRoute,
    private itemService: ItemService) { }

  ngOnInit(): void {
    let id = this.route.snapshot.paramMap.get("itemId");
    console.log(id);
    if (id != null) {
      this.itemService.getItem(id).subscribe(itemFromDb => {
        if (itemFromDb != null) {
          this.item = itemFromDb;
        } 
      })
    } 
  }

}
