export class Book{

    private _bookName:string;
    private _authorName:string;
        private _description:string;
        private _imageUrl:string;
        private _price:string 

    constructor(
        bookName:string,
        authorName:string,
        description:string,
        imageUrl:string,
        price:string 
        ){

            this._bookName =bookName;
        this._authorName =authorName;
        this._description =description;
        this._imageUrl =imageUrl;
        this._price =price 

        }

//getters
get name() : string {
    return this._bookName;
}

public get authorName() : string {
    return this._authorName;
}

public get description() : string {
    return this._description;
}

public get imageUrl() : string {
    return this._imageUrl;
}

public get price() : string {
    return this._price;
}

//setters
public set name(name : string) {
    this._bookName = name;
}

public set authorName(authorName : string) {
    this._authorName = authorName;
}

public set description(description : string) {
    this._description = description;
}

public set imageUrl(imageUrl : string) {
    this._imageUrl = imageUrl;
}

public set price(price : string) {
    this._price = price;
}



}