<%@page import="java.util.List"%>
<%@page import="com.others.ml.DataBase"%>
<%@page import="com.others.ml.Candidat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DashBoard</title>
<!--ONE LINE LIEN BOOTSTRAP  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/dashboard.css" rel="stylesheet" type="text/css"
	media="screen"></link>

</head>

<body>

<% 		DataBase db =new DataBase();


		List<Candidat> liste_Candidat = db.ListCandidat();
		
%>

	<nav class="navbar navbar-expand-lg navbar-primary bg-ligth" >

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo01"
			aria-controls="navbarTogglerDemo01" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>

		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo01">

			<img alt="" src="img/kalata.png" width="60px" />
			 <!-- <a class="navbar-brand kalata" id="kalata" href="#">
				KALATA</a> -->
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item">
				<a class="nav-link" href="<%=request.getContextPath()+"/ajouter"%>">
				 <button class="btn btn-outline-success " type="" style="">Ajouter candidat</button>
				</a></li>

				<li class="nav-item"><a class="nav-link" href="Election">
						<button class="btn btn-outline-secondary " type="" style="">
							Lancer l'election</button>
				</a></li>

			</ul>

			<form class="form-inline my-2 my-lg-0" action="login"
				method="get">

				<!-- <input class="form-control mr-sm-2" type="search" placeholder="Recherche" aria-label="Search"> -->
				<button class="btn btn-outline-danger my-2 my-sm-0 " type="submit">
					Deconnexion</button>
			</form>
		</div>
	</nav>
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
			  <img src="<%=us.getImage()%>" alt="Avatar" style="width:100%; margin-left:0px; margin-right:10px;">
			<div class="container">
			
			
			
			<a class="nav-link text-center" href="suprimer?id=<%=+us.getId()%>">
				 <button class="btn btn-danger "  style="">Retirer Candidat</button>
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


</body>
</html>