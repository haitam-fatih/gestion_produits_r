<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Comfirmation</title>
  </head>
  <body>
    <!-- code -->
    <div class="container mt-2 w-50">
    <c:import url="header.jsp" />
	    <div class="alert alert-success mt-3" role="alert">
		  ${ajouter}
		</div>
		<div>
			  <table class="table">
			  <c:if test="${produit!=null}">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <td scope="col">label</td>
			    </tr>
			    <tr>
			      <th scope="col">id</th>
			      <td scope="col">${produit.id}</td>
			    </tr>
			    <tr>
			      <th scope="col">designation</th>
			      <td scope="col">${produit.designation}</td>
			    </tr>
			    <tr>
			      <th scope="col">prix</th>
			      <td scope="col">${produit.prix}</td>
			    </tr>
			    <tr>
			      <th scope="col">quantite</th>
			      <td scope="col">${produit.quantite}</td>
			    </tr>
			  </thead>
			  </c:if>
          </table>
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