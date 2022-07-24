import { Component, OnInit, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/model/user';
import { LoginService } from 'src/service/login.service';
@Component({
  selector: 'app-form-login',
  templateUrl: './form-login.component.html',
  styleUrls: ['./form-login.component.scss'],
})

@Injectable({ providedIn: 'root' })
export class FormLoginComponent implements OnInit {

  user: User = new User();

  constructor(private router: Router, private loginService: LoginService) {}

  ngOnInit(): void {
    this.isLogged();
  }

  isLogged(): void {
    this.loginService.isLogged().subscribe((response) => {
      if (response.data === true) {
        this.router.navigate(['/']);
      }
    });
  }

  login():void {
    this.loginService.login(this.user).subscribe((response) => {
    });
  }
}
