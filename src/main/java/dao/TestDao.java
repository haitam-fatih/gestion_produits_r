package dao;

import java.util.List;

import metier.entities.Produit;

public class TestDao {

	public static void main(String[] args) {
		
		/*
		 * IProduitDao iProduitDao = new ProduitDaoImp(); Produit p1 =
		 * iProduitDao.ajouterProduit(new Produit(null,"designation1",2.25,25)); Produit
		 * p2 = iProduitDao.ajouterProduit(new Produit(null,"designation2",25.25,25));
		 * Produit p3 = iProduitDao.ajouterProduit(new
		 * Produit(null,"designation3",225.25,25));
		 * System.out.println(p1);System.out.println(p2);System.out.println(p3);
		 * System.out.println("/////////////////////////");
		 * iProduitDao.rechercheProduitParMC("designation1").forEach(p ->{
		 * System.out.println(p); });;
		 */
		
		/*
		 * IProduitDao iProduitDao = new ProduitDaoImp();
		 * System.out.println(iProduitDao.rechercheProduit(11L));
		 */
		
		IProduitDao iProduitDao = new ProduitDaoImp();
		
		System.out.println( iProduitDao.rechercheProduitbyId(10L));

		/*
		 * iProduitDao.allProduit().forEach(g->{ System.out.println(g); });
		 */
    
       
	}

}
