

<%@ page import="java.time.Month" %>
<%@ page import="mg.itu.entity.produit.ProduitMois" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
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
            <div class="row">

                <!--h1 class="h1 text-center"> Recherche Maladie</h1>
                <form action="${pageContext.request.contextPath}/rechercheProduitMois" method="post">
                    <div class="col-lg-4">
                        <label class="label label-info">Mois</label>
                        <select class="form-control" name="month">
                            <option value="">choisir</option>
                            <% for(int i = 1; i<=12;i++ ){ %>
                            <option value="<%=i%>"><%=i%></option>
                            <% } %>
                        </select>
                    </div>
                    <div class="col-lg-4">
                        <label class="label label-info">Année</label>
                        <select class="form-control" name="year">
                            <option value="">choisir</option>
                            <% for(int i = 2025; i>2023;i-- ){ %>
                            <option value="<%=i%>"><%=i%></option>
                            <% } %>
                        </select>
                    </div>
                    <div class="col-lg-2">
                        <button type="submit" class="btn btn-primary">Valider</button>
                    </div>
                </form>
            </div-->

            <h2>Liste des produits du mois</h2>
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Produit</th>
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
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="5" style="text-align: center;">Pas de Produit du mois</td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="assets/js/jquery.min.js"></script>

<!-- Bootstrap JS -->
<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>
