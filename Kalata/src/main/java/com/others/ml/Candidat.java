package com.others.ml;

import java.util.Date;

public class Candidat {
	Long id;
	protected String nom, prenom, image;
	protected Date date;
	protected int nb_vote;
public Candidat() {
	
}
public Candidat(String nom, String prenom, String image) {
	
	this.nom = nom;
	this.prenom = prenom;
	this.image = image;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

public int getNb_vote() {
	return nb_vote;
}

public void setNb_vote(int nb_vote) {
	this.nb_vote = nb_vote;
}

}
