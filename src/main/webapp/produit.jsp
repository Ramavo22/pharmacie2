<%@ page import="java.util.List" %>
<%@ page import="mg.itu.entity.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

    // load data
    List<Laboratoire> laboratoires = (List<Laboratoire>) request.getAttribute("laboratoires");
    List<TypeProduit> typeProduits = (List<TypeProduit>) request.getAttribute("typeProduits");
    List<Maladie> maladies = (List<Maladie>) request.getAttribute("maladies");
    List<Produit> produits = (List<Produit>) request.getAttribute("produits");

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
            <h1 class="text-center">Gestion des produits</h1>
            <form action="${pageContext.request.contextPath}/produit" method="post">
                <div class="form-group">
                    <!--input type="hidden" name="action">
                    <input type="hidden" name="id" %>"-->
                    <label for="nom">Nom du produit :</label>
                    <input type="text" class="form-control" id="nom" name="label" required>
                    <label for="prix">Prix</label>
                    <input type="number" class="form-control" name="prix" id="prix">
                    <label for="laboratoire">Laboratoire</label>
                    <select class="form-control" name="laboratoireId" id="laboratoire">
                        <option value="">choisir</option>
                        <% for (Laboratoire laboratoire : laboratoires) {%>
                            <option value="<%=laboratoire.getId()%>"><%=laboratoire.getLabel()%></option>
                        <% }%>
                    </select>
                    <label for="typeProduits">Type de produit</label>
                    <select class="form-control" name="typeProduitId" id = "typeProduits">
                        <option value="">choisir</option>
                        <% for (TypeProduit typeProduit : typeProduits) {%>
                        <option value="<%=typeProduit.getId()%>"><%=typeProduit.getLabel()%></option>
                        <% } %>
                    </select>
                    <div id="maladiesContainer">
                        <div class="row">
                            <div class="col-lg-6 compatible">
                                <label>Maladie traité</label>
                                <select class="form-control" name="compatibles[]">
                                    <option value="">choisir</option>
                                    <% for(Maladie maladie : maladies) {%>
                                    <option value="<%=maladie.getId()%>"><%= maladie.getLabel() %></option>
                                    <% } %>
                                </select>
                                <!-- Boutons pour ajouter et retirer des sélecteurs Maladie traité -->
                                <button type="button" class="btn btn-secondary mt-2 addCompatible">Ajouter un traité</button>
                                <button type="button" class="btn btn-danger mt-2 removeCompatible">Retirer un traité</button>
                            </div>
                            <div class="col-lg-6 nonCompatible">
                                <label>Maladie non compatible</label>
                                <select class="form-control" name="nonCompatibles[]">
                                    <option value="">choisir</option>
                                    <% for(Maladie maladie : maladies) {%>
                                    <option value="<%=maladie.getId()%>"><%= maladie.getLabel() %></option>
                                    <% } %>
                                </select>
                                <!-- Boutons pour ajouter et retirer des sélecteurs Maladie non compatible -->
                                <button type="button" class="btn btn-secondary mt-2 addNonCompatible">Ajouter un non compatible</button>
                                <button type="button" class="btn btn-danger mt-2 removeNonCompatible">Retirer un non compatible</button>
                            </div>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Ajouter</button>
            </form>

            <h2>Liste des Maladies</h2>
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Prix</th>
                    <th>TypeProduit</th>
                    <th>Laboratoire</th>
                    <th>Maladie traité</th>
                    <th>Non Compatible</th>
                </tr>
                </thead>
                <tbody>
                <%for (Produit produit : produits) {%>
                    <tr>
                        <td><%=produit.getId()%></td>
                        <td><%=produit.getLabel()%></td>
                        <td><%=produit.getPrix()%></td>
                        <td><%=produit.getTypeProduit().getLabel()%></td>
                        <td><%=produit.getLaboratoire()!=null ? produit.getLaboratoire().getLabel() : "Non spécifier"%></td>
                        <td><% if(produit.getMedicamentMaladies().size() > 0){%>
                            <ul>
                                <% for(MedicamentMaladie medicamentMaladie : produit.getMedicamentMaladies()){ %>
                                    <li> <%=medicamentMaladie.getMaladie().getLabel()%> </li>
                              <% }%>
                            </ul>
                            <% } else {%>
                                <p>Null</p>
                            <%}%>

                        </td>
                        <td><% if(produit.getMedicamentMaladieNonCompatibles().size() > 0){%>
                            <ul>
                                <% for(MedicamentMaladieNonCompatible medicamentMaladieNonCompatible : produit.getMedicamentMaladieNonCompatibles()){ %>
                                <li> <%= medicamentMaladieNonCompatible.getMaladie().getLabel() %> </li>
                                <% }%>
                            </ul>
                            <% }else {%>
                            <p>Null</p>
                            <%}%>
                        </td>
                    </tr>
                <% }%>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>
    document.getElementById("maladiesContainer").addEventListener("click", function(event) {
        // Gestion du bouton pour ajouter un sélecteur "Maladie traité"
        if (event.target.classList.contains("addCompatible")) {
            const newSelect = document.createElement("select");
            newSelect.className = "form-control mt-2";
            newSelect.setAttribute("name","compatibles[]")
            newSelect.innerHTML = `
                <option value="">choisir</option>
                <% for(Maladie maladie : maladies) {%>
                <option value="<%=maladie.getId()%>"><%= maladie.getLabel() %></option>
                <% } %>

            `;
            event.target.parentElement.insertBefore(newSelect, event.target);
        }

        // Gestion du bouton pour ajouter un sélecteur "Maladie non compatible"
        if (event.target.classList.contains("addNonCompatible")) {
            const newSelect = document.createElement("select");
            newSelect.className = "form-control mt-2";
            newSelect.setAttribute("name","nonCompatibles[]")
            newSelect.innerHTML = `
                <option value="">choisir</option>
                <% for(Maladie maladie : maladies) {%>
                <option value="<%=maladie.getId()%>"><%= maladie.getLabel() %></option>
                <% } %>
            `;
            event.target.parentElement.insertBefore(newSelect, event.target);
        }

        // Gestion du bouton pour retirer un sélecteur "Maladie traité"
        if (event.target.classList.contains("removeCompatible")) {
            const selects = event.target.parentElement.querySelectorAll("select");
            if (selects.length > 0) {
                selects[selects.length - 1].remove(); // Supprime le dernier sélecteur
            } else {
                alert("Impossible de supprimer.");
            }
        }

        // Gestion du bouton pour retirer un sélecteur "Maladie non compatible"
        if (event.target.classList.contains("removeNonCompatible")) {
            const selects = event.target.parentElement.querySelectorAll("select");
            if (selects.length > 0) {
                selects[selects.length - 1].remove(); // Supprime le dernier sélecteur
            } else {
                alert("Impossible de supprimer");
            }
        }
    });
</script>

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
