package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Produit;

public class ProduitDaoImp implements IProduitDao{

	@Override
	public Produit ajouterProduit(Produit p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into produit(designation , prix , quantite) values (?,?,?)");
			preparedStatement.setString(1, p.getDesignation());
			preparedStatement.setDouble(2, p.getPrix());
			preparedStatement.setInt(3, p.getQuantite());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("probléme de prepareStatement ajouter produit");
		}
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select max(id) as id from produit");
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				p.setId(resultSet.getLong("id"));
			}
		} catch (SQLException e) {
			System.out.println("probléme de selectionner le maximum id de produit inseré");
		}
		return p;
	}

	@Override
	public Produit editerProduit(Long idOld, Produit pNew) {
	   if(rechercheProduit(idOld)) {
		   Connection connection =  SingletonConnection.getConnection();
		   try {
			PreparedStatement preparedStatement = connection.prepareStatement("update produit set designation = ? ,prix = ? ,quantite = ? where id = ? ");
			preparedStatement.setString(1,pNew.getDesignation());
			preparedStatement.setDouble(2, pNew.getPrix());
			preparedStatement.setInt(3, pNew.getQuantite());
			preparedStatement.setLong(4,idOld);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			pNew.setId(idOld);
			return pNew ;
		} catch (SQLException e) {
		 System.out.println("probléme de modifier un produit");
		}
	   }
	return null;
		
	}

	@Override
	public Boolean supprimerProduit(Long idP) {
		int r = 0;
		try {
			PreparedStatement preparedStatement =  SingletonConnection.getConnection().prepareStatement("delete from produit where id = ?");
			preparedStatement.setLong(1, idP);
			r=preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("probléme de supprimer un produit");
		}
		return r==1?true:false;
	}

	@Override
	public List<Produit> rechercheProduitParMC(String MC) {
	Connection connection = SingletonConnection.getConnection();
	List<Produit> produits = new ArrayList<Produit>();
	try {
		PreparedStatement preparedStatement =  connection.prepareStatement("select * from produit where designation like ?");
		preparedStatement.setString(1,"%"+MC+"%");
		ResultSet resultSet =  preparedStatement.executeQuery();
		while (resultSet.next()) {
			Long id = resultSet.getLong("id") ;
			String designation = resultSet.getString("designation");
			double prix = resultSet.getDouble("prix");
			int quantite = resultSet.getInt("quantite");
			produits.add(new Produit(id,designation,prix,quantite));
		}
		preparedStatement.close();
	} catch (SQLException e) {
		System.out.println("probléme de recherche des Produits Par un designation");
	}
		return produits;
	}

	@Override
	public List<Produit> allProduit() {
		List<Produit> produits = new ArrayList<Produit>();
		 Connection connection =  SingletonConnection.getConnection();
		 try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from produit");
			ResultSet resultSet =  preparedStatement.executeQuery();
			while(resultSet.next()) {
				Long id = resultSet.getLong("id");
				String designation = resultSet.getString("designation");
				double prix = resultSet.getDouble("prix");
				int quantite = resultSet.getInt("quantite");
				produits.add(new Produit(id,designation,prix,quantite));
			}
			preparedStatement.close();
			
		} catch (SQLException e) {
		   System.out.println("probléme d'afficher tous les produits ");
		}
		return produits;
	}

	@Override
	public Boolean rechercheProduit(Long idP) {
		Boolean trouve = false ;
		try {
		PreparedStatement prepareStatement = SingletonConnection.getConnection().prepareStatement("select * from produit where id = ?");
		prepareStatement.setLong(1, idP);
		ResultSet resultSet =  prepareStatement.executeQuery();
		if(resultSet.next()) {
			trouve = true ;
		}
		} catch (SQLException e) {
			System.out.println("probléme de recherche Produit par id");
		}
		return trouve;
	}

	@Override
	public Produit rechercheProduitbyId(Long idP) {
		Produit produit = null ;
		try {
		PreparedStatement prepareStatement = SingletonConnection.getConnection().prepareStatement("select * from produit where id = ?");
		prepareStatement.setLong(1, idP);
		ResultSet resultSet =  prepareStatement.executeQuery();
		if(resultSet.next()) {
			Long id = resultSet.getLong(1);
			String designation = resultSet.getString(2);
			double prix = resultSet.getDouble(3);
			int quantite = resultSet.getInt(4);
			produit = new Produit(id, designation, prix, quantite);
		}
		} catch (SQLException e) {
			System.out.println("probléme de recherche Produit par id");
		}
		return produit;
	}

}
