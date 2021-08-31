import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Item } from 'src/app/models/item.model';
import { ItemService } from 'src/app/services/item.service';

@Component({
  selector: 'app-item-edit',
  templateUrl: './item-edit.component.html',
  styleUrls: ['./item-edit.component.css']
})
export class ItemEditComponent implements OnInit {
  item!: Item;
  editItemForm!: FormGroup;

  constructor(private route: ActivatedRoute,
    private itemService: ItemService,
    private router: Router) { }

  ngOnInit(): void {
    let id = this.route.snapshot.paramMap.get("itemId");
    console.log(id);
    if (id != null) {
      // let itemFound = this.itemService.getItem(id);
      this.itemService.getItem(id).subscribe(itemFromDb => {
        if (itemFromDb != null) {
          this.item = itemFromDb;
          this.editItemForm = new FormGroup({
            title: new FormControl(this.item.title),
            price: new FormControl(this.item.price),
            imgSrc: new FormControl(this.item.imgSrc),
            category: new FormControl(this.item.category),
          });
        } 
      })
    } 
  }

  onEditItem(editItemForm: FormGroup) {
    let item = new Item(
      editItemForm.value.title,
      editItemForm.value.imgSrc,
      editItemForm.value.price,
      editItemForm.value.category,
      this.item.id
    );
    this.itemService.editItem(item).subscribe(()=>{
      this.router.navigateByUrl("/admin/esemed");
    });
  }
}
