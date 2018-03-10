<!DOCTYPE html>
<html>
	<#include "./header.ftl">

<body>
    <div id="maindisplay"><img src="assets/img/1743799-512.png" id="logoimg">
        <div class="container" id="navbar">
            <div class="btn-group" role="group">
                <button class="btn btn-default" type="button" onclick="displayhidehome()"><a href="/home"> HOME </a> </button>
                <button class="btn btn-default" type="button" onclick="displayhideproducts()"><a href="/products"> PRODUCTS </a> </button>
                <button class="btn btn-default" type="button" onclick="displayhideaboutus()"><a href="/aboutus"> ABOUT US </a> </button>
                <button class="btn btn-default" type="button" onclick="displayhidecontactus()"><a href="/contactus"> CONTACT US </a></button>
                <button class="btn btn-default" type="button" onclick="displayhideLogin()"><a href="/login"> LOG IN </a></button>
                <button class="btn btn-default" type="button" onclick="displayhideRegister()"><a href="/register"> REGISTER </a></button>
                <button class="btn btn-default" type="button" onclick="displayhideME()"><a href="/me">ME</a></button>
            </div>
        </div>
        <h1 id="geekyparade">Geeky Parade 2</h1></div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

<style>
a{color:white;}
</style>



</html>
