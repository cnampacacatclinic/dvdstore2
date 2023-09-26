import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'dvdstore-angular';
  searchText = 'a';

  handleSearchInput = (event: any) => {
    this.searchText = event?.target.value
  }

  handleButtonSearchClick = () => {
    console.log(this.searchText)
  }
}