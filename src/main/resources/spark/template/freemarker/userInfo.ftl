<!DOCTYPE html>
<html>
	<#include "./header.ftl">
	<body>
		<#if user??>

<div id="loggeduserinfo"class="jumbotron">
<div id="datosdelusuario">
			<h1> ${user.getNombre()} </h1>
			<h1> ${user.getCorreo()} </h1>
</div>
			<a id="loggeduserGOBACKHOME" href="/start"> Go Back Home </a>
</div>




		<#else>
		<div id="unloggeruseralert"class="jumbotron">
	<h2>You need to log in first </h2>
	<a id="loggeduserGOBACKHOME" href="/start">go log in!</a>
   </div>

   <script>

   setTimeout(function(){ location.href="/start"; }, 1000);

   </script>

		</#if>




	</body>



<style>
#loggeduserinfo{
	text-align: center;
	width: 60%;
	margin-top: 40px;
	margin-left: auto;
	margin-right: auto;
		background:rgba(18,17,17,0.74);
	color:white;
	font-size: 35px;
}
#unloggeruseralert{
	text-align: center;
	width: 60%;
	margin-top: 40px;
	margin-left: auto;
	margin-right: auto;
	background:rgba(18,17,17,0.74);
color:white;
font-size: 35px;

}
body{
	background:url(../../assets/img/ben-neale-297658-unsplash.jpg);
  background-position:center;
  background-size:cover;
  background-repeat:no-repeat;
  background-attachment:fixed;
  text-align:center;
  vertical-align:middle;
}
#datosdelusuario{
	margin-bottom: 10px;
	margin-top: 10px;
}
#loggeduserGOBACKHOME{
	margin-top: 15px;
	border:thin white;
	width: 25%;
	padding: 20px;
	font-size: 20px;
	margin-bottom: 15px;
	background:rgba(13,11,11,0.56);
	color:white;
	border-radius:0;
	text-decoration: none;
}
#loggeduserGOBACKHOME:hover{text-decoration: none !important;}

</style>



</html>
