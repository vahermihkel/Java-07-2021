import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ItemService } from 'src/app/services/item.service';
// src/app/...... absoluutne teekond
// ../../.....  relatiivne teekond

@Component({
  selector: 'app-item-add',
  templateUrl: './item-add.component.html',
  styleUrls: ['./item-add.component.css']
})
export class ItemAddComponent implements OnInit {

  constructor(private itemService: ItemService) { }

  ngOnInit(): void {
  }

  onAddNewItem(form: NgForm) {
    console.log("töötab");
    console.log(form);
    console.log(form.value);
    if (form.valid) {
      this.itemService.addItem(form.value);
      form.reset();
    } else {
      alert("Jätsid midagi sisestamata! Palun kontrolli");
    }
  }
}
