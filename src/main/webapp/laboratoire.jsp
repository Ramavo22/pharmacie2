<%@ page import="mg.itu.entity.Laboratoire" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    List<Laboratoire> laboratoires = (List<Laboratoire>) request.getAttribute("laboratoires");
    Laboratoire modifLab = (Laboratoire) request.getAttribute("modifLab");
    String action  = (String) request.getAttribute("action");
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
                <h1 class="text-center">Gestion des Laboratoires</h1>
                <hr>

                <h1>Insertion Laboratoire</h1>
                <p>Remplissez le formulaire ci-dessous pour ajouter un nouveau laboratoire.</p>

                <form action="${pageContext.request.contextPath}/laboratoire" method="post">
                    <div class="form-group">
                        <input type="hidden" name="action" value="<%= action %>">
                        <input type="hidden" name="id" value="<% if(modifLab != null) out.print(""+modifLab.getId()); %>">
                        <label for="nom">Nom du Laboratoire :</label>
                        <input type="text" class="form-control" id="nom" name="label" value="<%if(modifLab != null) out.print(modifLab.getLabel());%>" required>
                    </div>

                    <button type="submit" class="btn btn-primary">Ajouter</button>
                </form>

                <!-- Tableau pour afficher la liste des laboratoires -->
                <h2>Liste des Laboratoires</h2>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for (Laboratoire laboratoire : laboratoires) {%>
                        <tr>
                            <td><%= laboratoire.getId() %></td>
                            <td><%= laboratoire.getLabel()%></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/laboratoire?action=ToUpdate&&id=<%= laboratoire.getId() %>">
                                    <button class="btn btn-warning">Modifier</button>
                                </a>
                                <a href="${pageContext.request.contextPath}/laboratoire?action=delete&&id=<%= laboratoire.getId() %>">
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
