<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Produits title</title>
  </head>
  <body>
    <!-- code -->
    <div class="container mt-2 w-50">
   <c:import url="header.jsp" />
	    <div class="card">
		  <div class="card-header">
		    <form action="recherche.produit" method="get">
			    <input type="text" class="form-control w-50 d-inline p-2" placeholder="recherche des produits" name="motCle">
			    <button type="submit" class="btn btn-primary d-inline p-2">Recherche</button>
			</form>
		  </div>
		  <div class="card-body">
		  <table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Designation</th>
			      <th scope="col">Prix</th>
			      <th scope="col">Quantite</th>
			    </tr>
			  </thead>
			  <tbody>
			
			   <c:forEach items="${produitModel.produits}" var="p">
			    <tr>
			      <td>${p.designation}</td>
			      <td>${p.prix}</td>
			      <td>${p.quantite}</td>
			      <td><a onclick="return confirm('vous étes sur que vous voulez supprimer ce produit ${p.id} ???')" class="btn btn-outline-danger" href="supprimer.produit?id=${p.id}" role="button">supprimer</a></td>
			      <td><a onclick="return confirm('vous étes sur que vous voulez editer ce produit ${p.id} ???')" class="btn btn-outline-primary" href="editer.produit?id=${p.id}" role="button">editer</a></td>
			    </tr>
			   </c:forEach>
			   
			  </tbody>
			</table>
		  </div>
	    </div>
    </div>
    <!-- code -->

    
    
    
    

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
  </body>
</html>