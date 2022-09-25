import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/models/Book';
import { SearchService } from 'src/app/services/search.service';
import { WishlistService } from 'src/app/services/wishlist.service';

@Component({
  selector: 'app-related-book-api',
  templateUrl: './related-book-api.component.html',
  styleUrls: ['./related-book-api.component.css'],
})
export class RelatedBookApiComponent implements OnInit {
  books: any = [];
  constructor(
    private searchService: SearchService,
    private wishlistService: WishlistService
  ) {}

  ngOnInit(): void {
    console.log('inside the ...');
    var val = localStorage.getItem('search');

    this.searchService.getDataByTitle(val).subscribe(
      (res) => {
        var myJsonString = JSON.stringify(res);
        var myJsonObject = JSON.parse(myJsonString);

        var coverurl = 'https://covers.openlibrary.org/b/isbn/';

        for (let index = 0; index < myJsonObject.docs.length - 1; index++) {
          var getbookName = myJsonObject.docs[index].title;

          var getisbn = myJsonObject.docs[index].isbn[0];
          if (getisbn == null) {
            getisbn = 'blank';
          }
          var getdescription = myJsonObject.docs[index].first_sentence;
          if (getdescription) {
            getdescription = 'No description available';
          }
          var getauthorName = myJsonObject.docs[index].author_name[0];
          if (getauthorName == null) {
            getauthorName = 'Unknown';
          }
          var getimageUrl = coverurl + getisbn + '-M.jpg';

          if (getisbn == null) {
            getimageUrl =
              'https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/1024px-No_image_available.svg.png';
          }

          console.log('......................');

          var obj = {};
          var myjsString = JSON.stringify(obj);
          var myObject = JSON.parse(myjsString);
          myObject.bookName = getbookName;
          myObject.authorName = getauthorName;
          myObject.imageUrl = getimageUrl;
          myObject.description = getauthorName;

          this.books.push(myObject);
        }
      },
      (err: any) => {
        console.log(err);
      }
    );






    this.searchService.getDataByAuthor(val).subscribe(
      (res) => {
        var myJsonString = JSON.stringify(res);
        var myJsonObject = JSON.parse(myJsonString);

        var coverurl = 'https://covers.openlibrary.org/b/isbn/';

        for (let index = 0; index < myJsonObject.docs.length - 1; index++) {
          var getbookName = myJsonObject.docs[index].title;

          var getisbn = myJsonObject.docs[index].isbn[0];
          if (getisbn == null) {
            getisbn = 'blank';
          }
          var getdescription = myJsonObject.docs[index].first_sentence;
          if (getdescription) {
            getdescription = 'No description available';
          }
          var getauthorName = myJsonObject.docs[index].author_name[0];
          if (getauthorName == null) {
            getauthorName = 'Unknown';
          }
          var getimageUrl = coverurl + getisbn + '-M.jpg';

          if (getisbn == null) {
            getimageUrl =
              'https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/1024px-No_image_available.svg.png';
          }

          console.log('......................');

          var obj = {};
          var myjsString = JSON.stringify(obj);
          var myObject = JSON.parse(myjsString);
          myObject.bookName = getbookName;
          myObject.authorName = getauthorName;
          myObject.imageUrl = getimageUrl;
          myObject.description = getauthorName;

          this.books.push(myObject);
        }
      },
      (err: any) => {
        console.log(err);
      }
    );
  }

  onBookClicked(book: Book) {
    var myJsonString = JSON.stringify(book);
    var myJsonObject = JSON.parse(myJsonString);
    myJsonObject.email = localStorage.getItem('email');

    console.log(myJsonObject);

    this.wishlistService.addToWishlist(myJsonObject).subscribe(
      (res) => {},
      (err) => {
        console.log(err);
      }
    );
  }
}
