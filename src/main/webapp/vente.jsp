<%@ page import="java.util.List" %>
<%@ page import="mg.itu.entity.vente.Vente" %>
<%@ page import="mg.itu.entity.produit.Produit" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    List<Vente> ventes = (List<Vente>) request.getAttribute("vente");
    Vente modifLab = (Vente) request.getAttribute("modifLab");
    String action  = (String) request.getAttribute("action");
    List<Produit> produits = (List<Produit>) request.getAttribute("produits");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des Ventes</title>

    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/styles.css" rel="stylesheet">
</head>
<body>
    <%@ include file="navigation.jsp"%>
    <div class="container-fluid">
        <div class="row">
            <%@ include file="sidebar.jsp" %>
            <div class="col-md-9">
                <h1 class="text-center">Gestion des Ventes</h1>
                <hr>

                <h1>Insertion vente</h1>
                <p>Remplissez le formulaire ci-dessous pour ajouter un nouveau vente.</p>

                <form action="${pageContext.request.contextPath}/vente" method="post">
                    <div class="form-group">
                     
                        <select name="produitId" class="form-control">
                            <option value="">Choisir</option>
                            <% for(Produit produit : produits){ %>
                            <option value="<%=produit.getId()%>"><%=produit.getLabel()%></option>
                            <% } %>
                        </select>
                        <label class="label label-info">Quantite :</label>
                        <input type="number" class="form-control" id="nom" name="quantite" value="" required>8
                        <label for="date" class="label label-info">Date :</label>
                        <input type="datetime-local" class="form-control" id="date" name="date" value="" required>
                    </div>

                    <button type="submit" class="btn btn-primary">Ajouter</button>
                </form>

                <!-- Tableau pour afficher la liste des vente -->
                <h2>Liste des Ventes</h2>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Produit</th>
                        <th>Prix Unitaire</th>
                        <th>Qte</th>
                        <th>Prix Total</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        if (ventes != null && !ventes.isEmpty()) {
                            for (Vente vente : ventes) {
                    %>
                    <tr>
                        <td><%= vente.getId() %></td>
                        <td><%= vente.getProduit().getLabel() %></td>
                        <td><%= vente.getPrixUnitaire() %></td>
                        <td><%= vente.getQuantite() %></td>
                        <td><%= vente.getQuantite() * vente.getPrixUnitaire() %></td>
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
    <!-- jQuery -->
    <script src="assets/js/jquery.min.js"></script>

    <!-- Bootstrap JS -->
    <script src="assets/js/bootstrap.min.js"></script>

    <!-- Script pour gérer les modifications -->
    <script>
        $(document).ready(function () {
            $('.btn-edit').on('click', function () {
                const id = $(this).data('id');
                const label = $(this).data('label');

                $('#lab-id').val(id);
                $('#lab-label').val(label);
            });
        });
    </script>
</body>
</html>
