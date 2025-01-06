<%@ page import="mg.itu.entity.Maladie" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    out.print("Jsp loader");
    List<Maladie> maladies = (List<Maladie>) request.getAttribute("maladies");
    String action = (String) request.getAttribute("action");
    Maladie modifMaladie = (Maladie) request.getAttribute("modifMaladie");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des Maladies</title>

    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/styles.css" rel="stylesheet">
</head>
<body>
    <%@ include file="navigation.jsp"%>
    <div class="container-fluid">
        <div class="row">
            <%@ include file="sidebar.jsp" %>
            <div class="col-md-9">
                <h1 class="text-center">Gestion des Maladies</h1>
                <hr>

                <p>Remplissez le formulaire ci-dessous pour ajouter une Maladie.</p>

                <form action="${pageContext.request.contextPath}/maladie" method="post">
                    <div class="form-group">
                        <input type="hidden" name="action" value="<%= action %>">
                        <input type="hidden" name="id" value="<% if(modifMaladie != null) out.print(modifMaladie.getId()); %>">
                        <label for="nom">Nom du Maladie :</label>
                        <input type="text" class="form-control" id="nom" name="label" value="<% if(modifMaladie != null) out.print(modifMaladie.getLabel()); %>" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Ajouter</button>
                </form>
                <h2>Liste des Maladies</h2>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for (Maladie maladie : maladies) {%>
                    <tr>
                        <td><%= maladie.getId() %></td>
                        <td><%= maladie.getLabel()%></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/maladie?action=toUpdate&&id=<%=maladie.getId()%>">
                                <button class="btn btn-warning">Modifier</button>
                            </a>
                            <a href="${pageContext.request.contextPath}/maladie?action=delete&&id=<%=maladie.getId()%>">
                                <button class="btn btn-danger">Modifer</button>
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
