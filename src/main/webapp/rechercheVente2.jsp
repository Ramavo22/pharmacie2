<%@ page import="java.util.List" %>
<%@ page import="mg.itu.entity.*" %>
<%@ page import="mg.itu.entity.vente.Vente" %>
<%@ page import="java.util.HashSet" %>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    List<Client> clients = (List<Client>) request.getAttribute("clients");
    List<Vente> ventes = (List<Vente>) request.getAttribute("ventes");
    HashSet<Client> clients1 = (HashSet<Client>) request.getAttribute("today");

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
                <form action="${pageContext.request.contextPath}/rechercheVente2" method="post">
                    <!--div class="col-lg-4">
                        <label class="label label-info">Clients :</label>
                        <select class="form-control" name="clientId">
                            <option value="">choisir</option>
                            <% for(Client client : clients){ %>
                            <option value="<%=client.getId()%>"><%=client.getLabel()%></option>
                            <%  }%>
                        </select>
                    </div-->
                    <div class="col-lg-4">
                        <label for="date" class="label label-info">Date :</label>
                        <input type="date" class="form-control" id="date" name="date">
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
                    <th>Clients</th>
                </tr>
                </thead>
                 <tbody>
                <% if (clients1 != null && !clients1.isEmpty()) { %>
                <% for (Client client : clients1) { %>
                <tr>
                    <td><%=client.getId()%></td>
                    <td><%=client.getLabel()%></td>
                </tr>
                <% } %>
                <% } else { %>
                <tr>
                    <td colspan="2" style="text-align: center;">Aucun élément n'a été trouvé</td>
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
