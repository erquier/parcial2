<!DOCTYPE html>
<html>
	<#include "./header.ftl">
<body>
    <div class="container floatingwindow" id="login-container">
        <div id="login-left">
            <h1 class="login-title">Login </h1><img src="assets/img/1276843-512.png">
             <form id="register-form" form action="/login" method="post">
                <div class="form-group">
                    <p class="login-text">Name </p>
                    <input class="form-control login-input" type="text">
                </div>
                <div class="form-group">
                    <p class="login-text">Email </p>
                    <input class="form-control login-input" type="text">
                </div>
                <div class="clearfix"></div>
                <div role="group" class="btn-group">
    <button class="btn btn-default btn-registerlogin-text submitLoG" type="submit" onclick="SubmitLogin()" id=login-btn>Log In</button>
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
