<%@ page import="java.util.List" %>
<%@ page import="mg.itu.entity.*" %>
<%@ page import="mg.itu.entity.HistoriquePrixProduits.HistoriquePrixProduit" %>
<%@ page import="mg.itu.utils.FrontUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

    // load data
    List<HistoriquePrixProduit> HistoriquePrixProduits = (List<HistoriquePrixProduit>) request.getAttribute("HistoriquePrixProduits");


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
            <h1 class="text-center">Historique Prix Produits</h1>
            <form action="${pageContext.request.contextPath}/HistoriquePrixProduits" method="post">
                <div class="form-group">
                   
                    <label for="HistoriquePrixProduits">Produits</label>
                    <select class="form-control" name="typeProduitId" id = "HistoriquePrixProduits">
                        <option value="">choisir</option>
                        <% for (HistoriquePrixProduit HistoriquePrixProduit : HistoriquePrixProduits) {%>
                        <option value="<%=HistoriquePrixProduit.getProduit_id().getId()%>"><%=HistoriquePrixProduit.getProduit_id().getLabel()%></option>
                        <% } %>
                    </select>
            
                </div>
                <button type="submit" class="btn btn-primary">Valider</button>
            </form>

            <h2>Liste des Maladies</h2>
            <table class="table table-bordered table-striped">
                <thead>
                <tr>

                    <th>Produits</th>
                    <th>Prix</th>
                    <th>Date</th>
                  
                </tr>
                </thead>
                <tbody>
                <% if (HistoriquePrixProduits != null && !HistoriquePrixProduits.isEmpty()) { %>
                <% for (HistoriquePrixProduit HistoriquePrixProduits : HistoriquePrixProduits) { %>
                <tr>
                
                    <td><%= HistoriquePrixProduits.getProduit_id().getLabel() %></td>
                    <td><%= HistoriquePrixProduits.getPrix() %></td>
                    <td><%= HistoriquePrixProduits.getDt_Prix() %></td>
                   
                <% } %>
                <% } else { %>
                <tr>
                    <td colspan="8" style="text-align: center;">Aucun élément n'a été trouvé</td>
                </tr>
                <% } %>
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
