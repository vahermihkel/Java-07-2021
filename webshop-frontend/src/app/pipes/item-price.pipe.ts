import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'itemPrice'
})
export class ItemPricePipe implements PipeTransform {

  transform(price: number): string {
    return price.toLocaleString('ee',{minimumFractionDigits:2, maximumFractionDigits: 2}) + "€";
  }

}
