<%@page import="com.servlet.ml.dashboard"%>
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
<link href="css/resultat.css" rel="stylesheet" type="text/css"
	media="screen"></link>
<title>Resultat election</title>
</head>

	<% 		
		DataBase db =new DataBase();
		List<Candidat> liste_Candidat = db.ListCandidat();
		System.out.println(liste_Candidat);
		
		dashboard ds=new dashboard();
	%>
<body>

<div class="div_bienvenu">
		<p class="msg_bienvenu">Resultat definitif des votes</p>
		
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
			 <img src="images/<%=us.getImage()%>" alt="Avatar" height=230px width=auto>
			<div class="container">
			
			
			
			<a class='resultat_affichage'>
				<progress id="resultat" value="<%= ds.pourcent(us.getNb_vote())%>"  max="100"></progress>
				<label id="pourcentage"><%= ds.pourcent(us.getNb_vote())%> % </label>
			</a>
			
			</div>
			
    	</div>
    	
    	
	    <%} %>
  	</div>
  	<a class="nav-link" href="login">
		<button class="btn btn-outline-danger " type="" style="">
			Fin de l'election</button>
				</a>
		    <%}else{ %>
	    <div class="aucun_candidat">
	    	<h1>Vous n'avez aucun resultat disponible</h1>
	    </div>
	<%} %>
	
	
</body>
</html>