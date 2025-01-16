<%@ page import="java.util.List" %>
<%@ page import="mg.itu.entity.*" %>
<%@ page import="mg.itu.entity.vente.Vente" %>

Created by IntelliJ IDEA.
  User: Ramavo Harinaivo
  Date: 09/01/2025
  Time: 08h59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    List<Clients> Client = (List<Clients>) request.getAttribute("client");
    List<Usage> usages = (List<Usage>) request.getAttribute("usages");

    List<Vente> ventes = (List<Vente>) request.getAttribute("ventes");

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
                <form action="${pageContext.request.contextPath}/rechercheVente" method="post">
                    <div class="col-lg-4">
                        <label class="label label-info">Clients :</label>
                        <select class="form-control" name="ClientsId">
                            <option value="">choisir</option>
                            <% for(Client Client : clients){ %>
                            <option value="<%=Client.getId()%>"><%=Client.getNom()%></option>
                            <%  }%>
                        </select>
                    </div>
                    <div class="col-lg-4">
                        <label for="date" class="label label-info">Date :</label>
                        <input type="date" class="form-control" id="date" name="date" required>
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
                    <th>ID</th>
                    <th>date de vente</th>
                    <th>Clients</th>
                    <th>Produits</th>
                  
                
                </tr>
                </thead>
                 <tbody>
                <% if (ventes != null && !ventes.isEmpty()) { %>
                <% for (Vente vente : ventes) { %>
                <tr>
                    <td><%=vente.getId()%></td>
                    <td><%=vente.getDateVente()%></td>
                    <td><%=vente.getClient()%></td>
                    <td><%=vente.getProduit().getLabel()%></td>

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

<!-- jQuery -->
<script src="assets/js/jquery.min.js"></script>

<!-- Bootstrap JS -->
<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>
