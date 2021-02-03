import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { UserprofileService } from 'src/app/services/userprofile.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  isLoggedIn = true;
  userName = "";
  userDetails:any = {
    contact: null,
    createdAt: null,
    email: null,
    firstName: null,
    lastName: null,
    userId: null
  };

  constructor(private tokenService: TokenStorageService, private userService: UserprofileService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.userName = this.tokenService.getUser();
    this.getUserDetails();
  }

  async getUserDetails() {
    await this.userService.getUserDetails(this.userName)
              .then(resp => {
                this.userDetails = resp;
              })
              .catch(error => {
                this.failureMessage(error.error.message);
              });
  }

  updateUser(): void {
    this.userService.updateUser(this.userDetails, this.userDetails.userId)
                    .then(response => {
                      this.successMessage("Updated Successfully");
                    })
                    .catch(error => {
                      this.failureMessage(error.error.message);
                    })
  }

  successMessage(message: string) {
    this.toastr.success(message);
  }

  failureMessage(message: string) {
    this.toastr.error(message);
  }

}
