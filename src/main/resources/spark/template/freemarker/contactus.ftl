<!DOCTYPE html>
<html>
	<#include "./header.ftl">

  <body>
    <div class="container floatingwindow" id="contactus">
        <button onclick="displayindex()"class="btn btn-default floatingwindow-title" type="button">CONTACT US</button>
        <div class="clearfix"></div>
        <form id="formulario-contacto">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="control-label FielName">Name </label>
                        <input class="form-control FormInput" type="text" id="name">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="control-label FielName">Email </label>
                        <input class="form-control FormInput" type="text" id="email">
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <label class="control-label FielName">Message </label>
                        <input class="form-control FormInput" type="text" id="message">
                    </div>
                </div>
            </div>
            <div class="btn-group" role="group">
                <button class="btn btn-default" type="submit" id="sendbtn">Send Message</button>
                <button class="btn btn-default" type="button" id="resetbtn">Reset Form</button>
            </div>
        </form>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
