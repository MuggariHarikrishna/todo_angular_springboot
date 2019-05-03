import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  errorMessage:string="Please Enter Valid Credentials";
  status:boolean=false;
  username:string="user";
  password:string="user";
  constructor(private router:Router,
              private loginService:LoginService) {
    
   }

  ngOnInit() {
  
  }

  handleLogin(){
    if(this.loginService.authenticate(this.username,this.password)){
      this.router.navigate(["welcome",this.username]);
    }
    else{
      this.status=true;
    }
  }

}
