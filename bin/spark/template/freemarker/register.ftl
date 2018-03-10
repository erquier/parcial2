<!DOCTYPE html>
<html>
	<#include "./header.ftl">
  <body>
      <div class="container floatingwindow" id="register-container">
          <div id="register-right">
              <h1 class="login-title">Register </h1><img src="assets/img/1276843-512.png">
              <form id="register-form" form action="/registro" method="post">
                  <div class="form-group">
                      <p class="register-text">Name </p>
                      <input class="form-control register-input" type="text" name="nombre">
                  </div>
                  <div class="form-group">
                      <p class="register-text">Email </p>
                      <input class="form-control register-input" type="text" name="correo">
                  </div>
                  <div class="form-group">
                      <p class="register-text">Password </p>
                      <input class="form-control register-input" type="text" name"password">
                  </div>
                  <div class="clearfix"></div>
                  <div role="group" class="btn-group">
      <button class="btn btn-default btn-registerlogin-text submitLoG" type="submit" onclick="SubmitRegister()" id=signup-btn>Sign Up</button>
      <button class="btn btn-default register-icon-btns" type="button"> <i class="fa fa-facebook-square"></i></button>
      <button class="btn btn-default register-icon-btns" type="button"> <i class="fa fa-google"></i></button>
      <button class="btn btn-default register-icon-btns" type="button"> <i class="fa fa-github"></i></button>
      
  </div>
              </form>
          </div>
      </div>
      <script src="assets/js/jquery.min.js"></script>
      <script src="assets/bootstrap/js/bootstrap.min.js"></script>
  </body>

  </html>
