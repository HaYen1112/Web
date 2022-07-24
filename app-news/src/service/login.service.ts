import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from 'src/model/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient) { }

  public isLogged():Observable<any> {
    return this.httpClient.get(environment.REST_API + "/check-logged");
  }

  public login(user:User):Observable<any> {
    return this.httpClient.post(environment.REST_API + "/security_check_login", user);
  }
}
