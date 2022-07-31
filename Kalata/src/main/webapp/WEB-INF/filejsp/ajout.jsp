<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Ajouter</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" media="screen"></link>
</head>
<body>


<div class="container" id="container">

	<div class="form-container sign-in-container">
		<form method="post" action="ajouter" enctype="multipart/form-data" >
<!-- 		enctype="multipart/form-data"
 -->			<h3>Ajouter un candidat</h3>
			
			<span></span>
			<input type="text" placeholder="Nom Candidat"  name="nom" required />
			<input type="text" placeholder="Prénom Candidat" name="prenom" required/>
			<input type="file" placeholder="Photo du candidat" name="img" required/>

			
			<button>Ajouter</button>
			
<!-- 			<a href="">Voir la liste des candidats!</a>
 -->		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-right">
				<img src="img/add.png" alt="Admin" width="120%" height="">
			</div>
		</div>
	</div>
</div>


</body>
</html>