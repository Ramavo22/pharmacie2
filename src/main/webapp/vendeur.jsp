<%@ page import="mg.itu.entity.Laboratoire" %>
<%@ page import="java.util.List" %>
<%@ page import="mg.itu.entity.vente.Vendeur" %>
<%@ page import="mg.itu.entity.Genre" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
  List<Vendeur> vendeurs = (List<Vendeur>) request.getAttribute("vendeurs");
  List<Genre> genres = (List<Genre>) request.getAttribute("genres");

%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Gestion des Laboratoires</title>

  <link href="assets/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/styles.css" rel="stylesheet">
</head>
<body>
<%@ include file="navigation.jsp"%>
<div class="container-fluid">
  <div class="row">
    <%@ include file="sidebar.jsp" %>
    <div class="col-md-9">
      <h1 class="text-center">Gestion des Vendeurs</h1>
      <hr>

      <h1>Insertion Vendeur</h1>
      <p>Remplissez le formulaire ci-dessous pour ajouter un nouveau vendeur.</p>

      <form action="${pageContext.request.contextPath}/vendeur" method="post">
        <div class="form-group">
          <label for="nom">Nom du Vendeur :</label>
          <input type="text" class="form-control" id="nom" name="nom" required>
        </div>
        <div class="form-group">
          <label for="nomm">Genre :</label>
          <select class="form-control" name="genreId">
              <% for(Genre genre: genres){ %>
            <option value="<%=genre.getId()%>"><%=genre.getLabel()%></option>
            <%}%>
          </select>

        </div>



        <button type="submit" class="btn btn-primary">Ajouter</button>
      </form>

      <!-- Tableau pour afficher la liste des laboratoires -->
      <h2>Liste des Vendeurs</h2>
      <table class="table table-bordered table-striped">
        <thead>
        <tr>
          <th>ID</th>
          <th>Nom</th>
          <th>Genre</th>
        </tr>
        </thead>
        <tbody>
        <% if(!vendeurs.isEmpty() || vendeurs != null){ %>
          <%for (Vendeur vendeur : vendeurs){%>
          <tr>
            <td><%=vendeur.getId()%></td>
            <td><%=vendeur.getName()%></td>
            <td><%=vendeur.getGenre().getLabel()%></td>
          </tr>
       <%}
       } else { %>

        <%}%>
        </tbody>
      </table>
    </div>
  </div>
</div>
<!-- jQuery -->
<script src="assets/js/jquery.min.js"></script>

<!-- Bootstrap JS -->
<script src="assets/js/bootstrap.min.js"></script>

<!-- Script pour gérer les modifications -->

</body>
</html>
