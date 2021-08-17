// 1. ei oleks 25 rida vasakult paremale või ülevalt alla
// 2. teen ühe muudatuse, siis läheb kõikjale kus seda kasutatakse
// 3. ei pea süvenema nägemaks, et on samasugused
// 4. item-add juures saan new Item() teha enne pushimist valideerimaks et pushitakse õige asi

// {title: string, imgSrc: string, price: number, category: string}
// {title: string, imgSrc: string, price: number, category: string}[]

// Item
// Item[]

export class Item {
    constructor(
        public title: string,
        public imgSrc: string,
        public price: number,
        public category: string
    ) {}
}

// export class Item2 {
//     public title: string;
//     public imgSrc: string;
//     public price: number;
//     public category: string;
//     constructor(
//         _title: string,
//         _imgSrc: string,
//         _price: number,
//         _category: string
//     ) {
//         this.title = _title;
//         this.imgSrc = _imgSrc;
//         this.price = _price;
//         this.category = _category;
//     }
// }