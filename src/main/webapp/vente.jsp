<%@ page import="mg.itu.entity.vente" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    List<vente> vente = (List<vente>) request.getAttribute("vente");
    vente modifLab = (vente) request.getAttribute("modifLab");
    String action  = (String) request.getAttribute("action");
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
                        </select>
                        <label class="label label-info">Quantite :</label>
                        <input type="number" class="form-control" id="nom" name="quantite" value="" required>
        

                        <label for="date" class="label label-info">Date :</label>
                        <input type="date" class="form-control" id="date" name="date" value="" required>
                    </div>

                    <button type="submit" class="btn btn-primary">Ajouter</button>
                </form>

                <!-- Tableau pour afficher la liste des vente -->
                <h2>Liste des Ventes</h2>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for (vente vente : vente) {%>
                        <tr>
                            <td><%= vente.getId() %></td>
                            <td><%= vente.getLabel()%></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/vente?action=ToUpdate&&id=<%= vente.getId() %>">
                                    <button class="btn btn-warning">Modifier</button>
                                </a>
                                <a href="${pageContext.request.contextPath}/vente?action=delete&&id=<%= vente.getId() %>">
                                    <button class="btn btn-danger">Supprimer</button>
                                </a>
                            </td>
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
