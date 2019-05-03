import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor() { }

  authenticate(username,password):boolean{
    if(username==="root" && password==="root"){
      sessionStorage.setItem("authenticatedUser",username);
      return true;
    }
    else{
      return false;
    }
  }

  isUserLoggedin():boolean{
    if(sessionStorage.getItem("authenticatedUser")!=null){
      return true;
    }
    return false;
  }

  logoutUser(){
    sessionStorage.removeItem("authenticatedUser");
  }

}
