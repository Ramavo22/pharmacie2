<%@ page import="mg.itu.entity.produit.Produit" %>
<%@ page import="java.util.List" %>
<%@ page import="mg.itu.entity.produit.ProduitMois" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    List<Produit> produits = (List<Produit>) request.getAttribute("produits");
    List<ProduitMois> produitMois = (List<ProduitMois>) request.getAttribute("produitMois");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pharmacie - Gestion</title>

    <link href="assets/styles.css" rel="stylesheet">
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%@ include file="navigation.jsp" %>
<!-- Sidebar -->
<div class="container-fluid">
    <div class="row">
        <%@ include file="sidebar.jsp" %>
        <div class="col-md-9">
            <!-- Main Content -->
            <h1 class="text-center">Produits du mois insertion</h1>
            <hr>

            <h1>Insertion Produit du mois</h1>
            <form action="${pageContext.request.contextPath}/produitMois" method="post">
                <div class="form-group">

                    <select name="produitId" class="form-control">
                        <option value="">Choisir</option>
                        <% for(Produit produit : produits){ %>
                        <option value="<%=produit.getId()%>"><%=produit.getLabel()%></option>
                        <% } %>
                    </select>
                    <label for="date" class="label label-info">Date :</label>
                    <input type="date" class="form-control" id="date" name="date" required>
                </div>
                <button type="submit" class="btn btn-primary">Ajouter</button>
            </form>

            <h2>Liste des Ventes</h2>
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Produit</th>
                    <th>Date</th>
                </tr>
                </thead>
                <tbody>
                <%
                    if (produitMois != null && !produitMois.isEmpty()) {
                        for (ProduitMois produitMois1 : produitMois) {
                %>
                <tr>
                    <td><%= produitMois1.getId() %></td>
                    <td><%= produitMois1.getProduit().getLabel() %></td>
                    <td><%=produitMois1.getDate()%></td>
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="5" style="text-align: center;">Pas de vente</td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Footer -->
<footer>
    <p>&copy; 2024 Pharmacie. Tous droits réservés.</p>
</footer>

<!-- jQuery -->
<script src="assets/js/jquery.min.js"></script>

<!-- Bootstrap JS -->
<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>
