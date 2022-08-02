package com.others.ml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

	public Connection connection;

//	Methode permettant d'etablir la connection avec la base de donnée

	public void InitialiseConnection() {

		// Chargement de la librairie mysql connector

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		}

//		connexion avec la base de données 

		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kalata", "root", "");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

//	La méthode permettant de créer un candidat

	public void CreerCandidat(Candidat candidat) {

		this.InitialiseConnection();
		
		
//		if(this.existe(candidat.getNom(), candidat.getPrenom())){
//	
//		}else {
//			variable requette qui envoyera la requette 
			try {
				
				
				PreparedStatement requette = this.connection
						.prepareStatement("INSERT INTO candidat(id_candidat,nom,prenom,date,image) VALUES(0,?,?,NOW(),?);");

			
				
				requette.setString(1, candidat.getNom());
				requette.setString(2, candidat.getPrenom());
				requette.setString(3, candidat.getImage());

				requette.executeUpdate();
				
				requette.close();
				connection.close();
				

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}


//	}

//	Méthode permettant de retouner la liste des utilisateurs

	public List<Candidat> ListCandidat() {

//		Declaration d'une liste qui recevra la liste
		
		List<Candidat> candidats = new ArrayList<Candidat>();

//		Deux variable requette qui envoyera la requette et resultat qui la recevra

		Statement requette = null;
		ResultSet resultat = null;

//		se connecter à la base de données

		this.InitialiseConnection();

		try {

			requette = this.connection.createStatement();

//			execution de la requette
			resultat = requette.executeQuery("Select * FROM candidat;");

//			recuperation des resultats un à un
			while (resultat.next()) {

				Candidat user = new Candidat();
				user.setId(resultat.getLong("id_candidat"));
				user.setNom(resultat.getString("nom"));
				user.setPrenom(resultat.getString("prenom"));
				user.setDate(resultat.getDate("date"));
				user.setImage(resultat.getString("image"));
				user.setNb_vote(resultat.getInt("nb_vote"));
				
				candidats.add(user);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
//			A la fin de la requette on vas ferme la connection

			try {
				if (resultat != null) {
					resultat.close();
				}
				if (requette != null) {
					requette.close();
				}
				if (this.connection != null) {
					this.connection.close();
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		return candidats;
	}

	// Verification si l'utilisateur est déjà inscrire
	public boolean existe(String nom, String prenom) {

		// creation d'une varable user de type boolean pour verifier si

		boolean candidat = false;

		// reconnecte la base de données
		this.InitialiseConnection();
		try {
			PreparedStatement requette = this.connection
					.prepareStatement("SELECT * FROM Candidat WHERE nom = ? and prenom = ?;");

			requette.setString(1, nom);
			requette.setString(2, prenom);
			ResultSet result = requette.executeQuery();
			candidat = result.next();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return candidat;

	}

//	methode pour la connection d'un utilisateur
	public Candidat login(String pseudo, String password) {

//		creation d'un utilisateur qui sera retouner
		Candidat user = null;

//		Deux variable requette qui envoyera la requette et resultat qui la recevra

		this.InitialiseConnection();

		try {

			PreparedStatement requette = this.connection
					.prepareStatement("SELECT * FROM Candidat WHERE pseudo = ? and password = ?;");

			requette.setString(1, pseudo);
			requette.setString(2, password);

			ResultSet result = requette.executeQuery();

			if (result.next()) {
				user = new Candidat();
				user.setNom(result.getString("nom"));
//				user.setPseudo(result.getString("prenom"));
//				user.setPseudo(result.getString("pseudo"));
//				user.setEmail(result.getString("email"));

			}

			result.close();
			requette.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return user;
	}
	
//	methode permettant de supprimer un candidat
	public void SuprimeeCandidat(int id) {

		this.InitialiseConnection();

//		variable requette qui envoyera la requette 
		try {

			PreparedStatement requette = this.connection
					.prepareStatement("Delete from candidat WHERE id_candidat=?;");

			requette.setLong(1, id);
			

			requette.executeUpdate();

			requette.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void Voter(int id) {
		
		this.InitialiseConnection();
		
//		appel de k'utilisateur
		try {
			PreparedStatement requette = this.connection
					.prepareStatement("SELECT nb_vote FROM Candidat WHERE id_candidat = ? ;");

			requette.setLong(1, id);
			ResultSet result = requette.executeQuery();
			
			if(result.next()) {
				Candidat cd=new Candidat();
				int nbre=result.getInt("nb_vote");
				nbre+=1;
				
				PreparedStatement requet = this.connection
						.prepareStatement("Update candidat SET nb_vote=? WHERE id_candidat=?;");

				requet.setLong(1, nbre);
				requet.setLong(2, id);


				requet.executeUpdate();
				
				requette.close();
				connection.close();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

		
	}



}
