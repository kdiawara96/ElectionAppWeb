package com.servlet.ml;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.others.ml.Admin;
import com.others.ml.Candidat;
import com.others.ml.DataBase;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/filejsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		Admin  ad = new Admin();
		
		String pseudo = ad.getPseudo();
		String password = ad.getPassword();
		
		String pseudoSaisi , passwordSaisi;
		
		pseudoSaisi = request.getParameter("pseudo");
		passwordSaisi = request.getParameter("password");
		
		if(passwordSaisi.equals(password) && pseudoSaisi.equals(pseudo)) {
			
//			Recuperation de la liste des candidats
			DataBase db =new DataBase();
			List<Candidat> liste_Candidat=db.ListCandidat();
			
			
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/filejsp/dashboard.jsp").forward(request, response);

			
		}else {
			request.setAttribute("error", "Pseudo ou mot de passe invalide!");
			this.getServletContext().getRequestDispatcher("/WEB-INF/filejsp/login.jsp").forward(request, response);

		}
		
	}

}
