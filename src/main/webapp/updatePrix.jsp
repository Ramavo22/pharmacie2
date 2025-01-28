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
            <form action="${pageContext.request.contextPath}/historique" method="post">
                <div class="form-group">
                   
                    <label for="Produits">Produits</label>
                    <select class="form-control" name="typeProduitId" id = "Produits">
                        <option value="">choisir</option>
                        <% for (HistoriquePrixProduit HistoriquePrixProduit : HistoriquePrixProduits) {%>
                        <option value="<%=HistoriquePrixProduit.getProduit_id().getId()%>"><%=HistoriquePrixProduit.getProduit_id().getLabel()%></option>
                        <% } %>
                    </select>
                    <label for="Prix">Prix</label>
                    <input type="number" class="form-control" name="prix" id="prix">


                    <label for="date1" class="label label-info">Date :</label>
                    <input type="date" class="form-control" id="date1" name="date">

                </div>
                <button type="submit" class="btn btn-primary">Valider</button>
            </form>

           
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
