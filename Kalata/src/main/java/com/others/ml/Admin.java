package com.others.ml;

public class Admin {

	protected String pseudo = "admin";
	protected String  password = "kalanso" ;
	
	public Admin() {
		
	}
	
	public Admin(String pseudo, String password) {
		this.pseudo = pseudo;
		this.password = password;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
