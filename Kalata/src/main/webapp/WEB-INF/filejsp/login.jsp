<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/style.css" rel="stylesheet" type="text/css" media="screen"></link>
    <title>Connexion</title>
</head>
<body>


<!--<h2>Bienvenue sur la page d'authentification</h2>-->
<div class="container" id="container">

	<div class="form-container sign-in-container">
		<form action="login" method="post">
		<img alt="" src="img/kalata.png" width="70px"  />
			<h1>Connexion</h1>
			 <div >
		    <%
		    if(request.getAttribute("error") != null){%>
		    	<p class="error">${error}
		    	</p>
		   <%}%>
		 </div>
			<span></span>
			<input type="text" placeholder="Pseudo" name="pseudo"/>
			<input type="password" placeholder="Mot de passe" name="password" />
			<a href="#">Mot de passe oublié ?</a>
			<button type="submit">Se connecter</button>
		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			
			<div class="overlay-panel overlay-right">
				<img src="img/admin.png" alt="Admin">
			</div>
		</div>
	</div>
</div>

</body>
</html>