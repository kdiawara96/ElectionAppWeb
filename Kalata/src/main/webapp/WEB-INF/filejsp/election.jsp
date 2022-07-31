<%@page import="com.others.ml.Candidat"%>
<%@page import="java.util.List"%>
<%@page import="com.others.ml.DataBase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/vote.css" rel="stylesheet" type="text/css"
	media="screen"></link>

<title>Insert title here</title>
</head>
<% 		
	DataBase db =new DataBase();
	List<Candidat> liste_Candidat = db.ListCandidat();
	System.out.println(liste_Candidat);
%>
<body>
<div class="container">
 	
 	<nav class="navbar navbar-expand-lg navbar-primary bg-ligth" >

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo01"
			aria-controls="navbarTogglerDemo01" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>

		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo01">

			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item">
				<a class="nav-link" href="<%=request.getContextPath()+"/dashboard"%>">
				 <button class="btn btn-outline-danger " type="" style="">Annuler Election</button>
				</a></li>

				

			</ul>

			<form class="form-inline my-2 my-lg-0" action="dashboard"
				method="post">

				<!-- <input class="form-control mr-sm-2" type="search" placeholder="Recherche" aria-label="Search"> -->
				<button class="btn btn-outline-success my-2 my-sm-0 " type="submit">
					Afficher resultat</button>
			</form>
		</div>
	</nav>
 	
 	
 	
 	
 	
 	<div class="div_bienvenu">
		<p class="msg_bienvenu">Bienvenue Sur la platforme de vote Kalata</p>
		<p class="msg_comment">Cliquer sur le bouton voter en bas du candidat de votre choix</p>
		
	</div>

	<%if (!liste_Candidat.isEmpty()){ %>
	<div class="d-flex">	
	   <%for(Candidat us : liste_Candidat){
		   
		   %>
	   
	 	<div class="card">
	 	
	 	
	 		<h4 class="nom_prenom">
			   <b>
			      </i> <% out.print(us.getNom()+ " " + us.getPrenom()); %>
			   </b>
			</h4>
			  <img src="img/cv.jpg" alt="Avatar" style="width:100%; margin-left:0px; margin-right:10px;">
			<div class="container">
			<a class="nav-link text-center" href="Election?id=<%=+us.getId()%>">
				 <button class="btn btn-success "  style="">Voter</button>
				</a>
			</div>
			
    	</div>
	    <%} %>
  	</div>
		    <%}else{ %>
	    <div class="aucun_candidat">
	    	<h1>Aucun Candidat pour le moment!</h1>
	    </div>
	<%} %>
</div>

	

</body>
</html>