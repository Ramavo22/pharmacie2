<%@ page import="java.util.List" %>
<%@ page import="mg.itu.entity.*" %>
<%@ page import="mg.itu.entity.produit.Produit" %><%--
  Created by IntelliJ IDEA.
  User: Ramavo Harinaivo
  Date: 09/01/2025
  Time: 08h59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    List<Produit> produits = (List<Produit>) request.getAttribute("produits");
    List<Maladie> maladies = (List<Maladie>) request.getAttribute("maladies");
    List<TypePersonne> typePersonnes = (List<TypePersonne>) request.getAttribute("typePersonnes");



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

                <h1 class="h1 text-center"> Recherche Maladie</h1>
                <form action="${pageContext.request.contextPath}/rechercheMaladie" method="post">
                    <div class="col-lg-4">
                        <label class="label label-info">Maladie</label>
                        <select class="form-control" name="maladieId">
                            <option value="">choisir</option>
                            <% for(Maladie maladie : maladies){ %>
                            <option value="<%=maladie.getId()%>"><%=maladie.getLabel()%></option>
                          <%  }%>
                        </select>
                    </div>
                    <div class="col-lg-4">
                        <label class="label label-info">Personne</label>
                        <select class="form-control" name="typePersonneId">
                            <option value="">choisir</option>
                            <% for(TypePersonne typePersonne : typePersonnes){ %>
                            <option value="<%=typePersonne.getId()%>"><%=typePersonne.getNom()%></option>
                            <%  }%>
                        </select>
                    </div>
                    <div class="col-lg-2">
                        <button type="submit" class="btn btn-primary">Valider</button>
                    </div>
                </form>
            </div>

            <h2>Liste des Maladies</h2>
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Prix</th>
                    <th>TypeProduit</th>
                    <th>Dédie géneralement</th>
                    <th>Laboratoire</th>
                    <th>Maladie traité</th>
                    <th>Non Compatible</th>
                </tr>
                </thead>
                <tbody>
                <% if (produits != null && !produits.isEmpty()) { %>
                <% for (Produit produit : produits) { %>
                <tr>
                    <td><%= produit.getId() %></td>
                    <td><%= produit.getLabel() %></td>
                    <td><%= produit.getPrix() %></td>
                    <td><%= produit.getTypeProduit().getLabel() %></td>
                    <td><%= produit.getTypePersonne().getNom() %></td>
                    <td><%= produit.getLaboratoire() != null ? produit.getLaboratoire().getLabel() : "Non spécifier" %></td>
                    <td>
                        <% if (produit.getMedicamentMaladies().size() > 0) { %>
                        <ul>
                            <% for (MedicamentMaladie medicamentMaladie : produit.getMedicamentMaladies()) { %>
                            <li><%= medicamentMaladie.getMaladie().getLabel() %></li>
                            <% } %>
                        </ul>
                        <% } else { %>
                        <p>Null</p>
                        <% } %>
                    </td>
                    <td>
                        <% if (produit.getMedicamentMaladieNonCompatibles().size() > 0) { %>
                        <ul>
                            <% for (MedicamentMaladieNonCompatible medicamentMaladieNonCompatible : produit.getMedicamentMaladieNonCompatibles()) { %>
                            <li><%= medicamentMaladieNonCompatible.getMaladie().getLabel() %></li>
                            <% } %>
                        </ul>
                        <% } else { %>
                        <p>Null</p>
                        <% } %>
                    </td>
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
