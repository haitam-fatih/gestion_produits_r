package model;

import java.util.List;

import metier.entities.Produit;

public class ProduitModel {
  
	private String motCle ;
	private List<Produit> produits ;
	
	public ProduitModel() {
	}

	public ProduitModel(String motCle, List<Produit> produits) {
		super();
		this.motCle = motCle;
		this.produits = produits;
	}

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		return "ProduitModel [motCle=" + motCle + ", produits=" + produits + "]";
	}
}
