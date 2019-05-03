import { Component, OnInit } from '@angular/core';
import { DataService } from '../service/data.service';
// import { DataService } from '../service/data.service';

@Component({
  selector: 'app-todos',
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.css']
})

export class TodosComponent implements OnInit {

  // todos=[{"description":"enjoy","targetDate":new Date(),"done":false},
  // {"description":"study","targetDate":new Date(),"done":false},
  // {"description":"play cricket","targetDate":new Date(),"done":false}]
  todos=[];
  username:string="";
  constructor(private dataService:DataService) { }

  ngOnInit(){
    this.refreshTodos();
  }
  
  refreshTodos(){
    const u_name=sessionStorage.getItem("authenticatedUser");
    this.dataService.get(`users/${u_name}/todos`).subscribe(
      response => {
        console.log(response);
        // this.todos = response;
      }
    )
  }
  

}
