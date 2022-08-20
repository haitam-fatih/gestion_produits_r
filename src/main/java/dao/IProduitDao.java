package dao;

import java.util.List;

import metier.entities.Produit;

public interface IProduitDao {
   
	public Produit ajouterProduit(Produit p);
	public Produit editerProduit(Long idOld , Produit pNew);
	public Boolean supprimerProduit(Long idP);
	public List<Produit> rechercheProduitParMC(String MC);
	public List<Produit> allProduit();
	public Boolean rechercheProduit(Long idP);
	public Produit rechercheProduitbyId(Long idP);
}
