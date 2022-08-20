package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import dao.IProduitDao;
import dao.ProduitDaoImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.entities.Produit;
import model.ProduitModel;
// ce class est instancier une seul fois comme singletonConnection
@WebServlet(name ="controllerProduit" , urlPatterns = "*.produit")
public class ControllerProduit extends HttpServlet{
	private IProduitDao iProduitDao ;
   
	@Override
	public void init() throws ServletException {
		iProduitDao = new ProduitDaoImp();
		System.out.println("iam init");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* req.set est interdé car le principe de encapsulation */ 
	// page d'acceuil	
	if(req.getServletPath().equals("/.produit")) {
		
		List<Produit> produits =  iProduitDao.allProduit();
		ProduitModel produitModel = new ProduitModel(null,produits);
		req.setAttribute("produitModel", produitModel);
		req.getRequestDispatcher("produits.jsp").forward(req, resp);	
	}
	// page de la recherche un produit
	else if (req.getServletPath().equals("/recherche.produit")) {
		String motCle = req.getParameter("motCle");
		if(motCle.equals("")) {
			resp.sendRedirect(req.getContextPath()+"/.produit");
		}
		else {
		ProduitModel produitModel = new ProduitModel(motCle,iProduitDao.rechercheProduitParMC(motCle));
		req.setAttribute("produitModel", produitModel);
		req.getRequestDispatcher("produits.jsp").forward(req, resp);
		}	
	}
	// page d'ajouter un produit
	else if (req.getServletPath().equals("/ajouter.produit")) {
		req.setAttribute("produit", new Produit());
		req.getRequestDispatcher("ajouterProduit.jsp").forward(req, resp);
		
	}
	// comfirmation d'ajouter produit
	else if (req.getServletPath().equals("/save.produit") && req.getMethod().equals("POST")) {
		String Designation = req.getParameter("Designation");
		double Prix =  Double.parseDouble(req.getParameter("Prix"));
		int Quantite = Integer.parseInt(req.getParameter("Quantite"));
		Produit p = new Produit(Designation,Prix,Quantite);
		Produit produit = iProduitDao.ajouterProduit(p);
		req.setAttribute("produit", produit);
		req.setAttribute("ajouter", "le produit à été ajouter avec success");
		req.getRequestDispatcher("comfirmation.jsp").forward(req, resp);
	}
	//supprimer un produit
	else if(req.getServletPath().equals("/supprimer.produit")) {
		Long id = Long.parseLong(req.getParameter("id"));
		 Boolean supprimer = iProduitDao.supprimerProduit(id);
		 req.setAttribute("ajouter", "le produit à été supprimer avec success");
		 req.getRequestDispatcher("comfirmation.jsp").forward(req, resp);	 
	}
	// editer produit
	else if(req.getServletPath().equals("/editer.produit")) {
		Long id = Long.parseLong(req.getParameter("id"));
		Produit produit = iProduitDao.rechercheProduitbyId(id);
		req.setAttribute("produit", produit);
		req.getRequestDispatcher("editerProduit.jsp").forward(req, resp);
	}
	// comfirmation d'éditer produit
	else if (req.getServletPath().equals("/edite.produit") && req.getMethod().equals("POST")) {
		Long id = Long.parseLong(req.getParameter("id"));
		String Designation = req.getParameter("Designation");
		double Prix =  Double.parseDouble(req.getParameter("Prix"));
		int Quantite = Integer.parseInt(req.getParameter("Quantite"));
		Produit p = new Produit(id,Designation,Prix,Quantite);
		Produit produit = iProduitDao.editerProduit(id,p);
		req.setAttribute("produit", produit);
		req.setAttribute("ajouter", "le produit à été modifier avec success");
		req.getRequestDispatcher("comfirmation.jsp").forward(req, resp);
	}

	else {
		resp.setStatus(404);
	}
		   
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// tous les requéte doPost passent à la doget avec un bloc de condition
		doGet(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("iam destroy");
	}
}
