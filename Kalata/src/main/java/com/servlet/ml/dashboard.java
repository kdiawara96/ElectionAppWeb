package com.servlet.ml;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.others.ml.Candidat;
import com.others.ml.DataBase;

/**
 * Servlet implementation class dashboard
 */
public class dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/filejsp/dashboard.jsp").forward(request, response);

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		
		
		
//		System.out.println(nbre_vote);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/filejsp/Resultat.jsp").forward(request, response);
	}
	
	public double pourcent(int valeur){
		
		DataBase db =new DataBase();
		int nbre_vote=0;

		List<Candidat> liste_Candidat = db.ListCandidat();
		for(Candidat c:liste_Candidat) {
			nbre_vote += c.getNb_vote();
	
		}
		System.out.println((valeur*100)/nbre_vote);
		return (valeur*100)/nbre_vote;
	}
	
	
	
	

}
