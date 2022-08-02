package com.servlet.ml;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.others.ml.Candidat;
import com.others.ml.DataBase;

/**
 * Servlet implementation class ajouter
 */
@MultipartConfig

public class ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final int TAILLE_TAMPON = 10240;
	public static final String CHEMIN = "/Users/kddiawara/Desktop/Image_kalata";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ajouter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/filejsp/ajout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataBase db = new DataBase();

//		System.out.println(request.getParameter("img"));
//		
//		File img=request.getFi("img");
//		
//		String encodedfile = null;
//       

//		System.out.println(nom);
//		on verifie qu'on a bien recu un fichier
//		String Nom_file=Nom_file(img);

//		if(Nom_file!=null && !Nom_file.isEmpty()) {
//			String nomChamp=img.getName();
//		}
//		List<Candidat> liste_Candidat=Array;

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		Part file = request.getPart("img");
		
		String imageFileName =file.getSubmittedFileName();
		
		String uploadPath = "C:/Users/kddiawara/eclipse-workspace/Kalata/src/main/webapp/images/"+imageFileName;
		

			try {
				FileOutputStream fos=new FileOutputStream(uploadPath);
				InputStream is=file.getInputStream();
				byte[] data=new byte[is.available()];
				is.read(data);
				fos.write(data);
				fos.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		
		Candidat candidat = new Candidat();
		
		candidat.setNom(nom);
		candidat.setPrenom(prenom);
		candidat.setImage(imageFileName);
		
if(db.existe(candidat.getNom(), candidat.getPrenom())) {
	request.setAttribute("error", "Les données existe déjà!");
	this.getServletContext().getRequestDispatcher("/WEB-INF/filejsp/ajout.jsp").forward(request, response);

}else {
	request.setAttribute("succes", "Candidat ajouter avec succes!");

	db.CreerCandidat(candidat);
	this.getServletContext().getRequestDispatcher("/WEB-INF/filejsp/ajout.jsp").forward(request, response);

}

	}

//	public  static String Nom_file(Part part){
//		for(String contentDisposition:part.getHeader("content-disposition").split(";")) {
//			if(contentDisposition.trim().startsWith("filename")) {
//				return contentDisposition.substring(contentDisposition.indexOf('=')+1).trim().replace("\"", "");
//			}
//		}
//		return null;
//	}

}
