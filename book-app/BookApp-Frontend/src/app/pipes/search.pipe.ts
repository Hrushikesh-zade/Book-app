import { Pipe, PipeTransform } from '@angular/core';
import { Book } from '../models/Book';

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {

  transform(value: Book[], searchText:string): Book[] {
    if(value.length===0 || searchText === ""){
      return value
    }
    const cont=[];
    for(const val of value){
      if(val.name.includes(searchText) || val.authorName.includes(searchText)){
        cont.push(val);
      }
    }
    return cont;
  }

}
