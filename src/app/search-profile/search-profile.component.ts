import { Component, OnInit } from '@angular/core';
import axios from 'axios';


@Component({
  selector: 'app-search-profile',
  templateUrl: './search-profile.component.html',
  styleUrls: ['./search-profile.component.scss']
})
export class SearchProfileComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    
  }

  searchProfile() {
    // axios.post('http://localhost:8080/skill-tracker/api/v1/admin/{criteria}/{criteriaValue}', )
  }

}
