<%@ page import="java.util.List" %>
<%@ page import="mg.itu.dto.CommissionVendeurDTO" %>
<%@ page import="mg.itu.utils.FrontUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  List<CommissionVendeurDTO> commissions = (List<CommissionVendeurDTO>) request.getAttribute("commissions");
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

        <h1 class="h1 text-center"> Recherche Vente Par Clients</h1>
        <form action="${pageContext.request.contextPath}/commission" method="post">
          <div class="col-lg-4">
            <label for="date1" class="label label-info">Debut :</label>
            <input type="date" class="form-control" id="date1" name="start">
          </div>
          <div class="col-lg-4">
            <label for="date" class="label label-info">fin :</label>
            <input type="date" class="form-control" id="date" name="end">
          </div>

          <div class="col-lg-2">
            <button type="submit" class="btn btn-primary">Valider</button>
          </div>
        </form>
      </div>

      <h2>Liste des Ventes</h2>
      <table class="table table-bordered table-striped">
        <thead>
        <tr>
          <th>idvente</th>
          <th>medicament</th>
          <th>prix unitaire</th>
          <th>quantité</th>
          <th>prix vente total</th>
          <th>Vendeur</th>
          <th>Date de vente</th>
          <th>commission</th>
        </tr>
        </thead>
        <tbody>
        <% if (commissions != null && !commissions.isEmpty()) { %>
        <% for (CommissionVendeurDTO commission : commissions) { %>
        <tr>
          <td><%=commission.getVente().getId()%></td>
          <td><%=commission.getVente().getProduit().getLabel()%></td>
          <td><%=FrontUtils.priceFormater(commission.getVente().getPrixUnitaire())%></td>
          <td><%=commission.getVente().getQuantite()%></td>
          <td><%=FrontUtils.priceFormater(commission.getVente().getPrixTotal())%></td>
          <td><%=commission.getVente().getVendeur().getName()%></td>
          <td><%=FrontUtils.dateFormater(commission.getVente().getDateVente())%></td>
          <td><%=FrontUtils.priceFormater(commission.getCommission())%></td>
        </tr>
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
</footer>§

<!-- jQuery -->
<script src="assets/js/jquery.min.js"></script>

<!-- Bootstrap JS -->
<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>
