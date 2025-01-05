<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <div class="container">
        <h1 class="text-center">Gestion des Maladies</h1>

        <hr>

        <!-- Tableau pour afficher la liste des maladies -->
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
                <%-- Récupération et affichage des maladies --%>
                <c:forEach var="lab" items="${maladies}">
                    <tr>
                        <td>${lab.id}</td>
                        <td>${lab.label}</td>
                        <td>
                            <button class="btn btn-warning btn-edit" 
                                    data-id="${lab.id}" 
                                    data-label="${lab.label}">
                                Modifier
                            </button>
                            <form action="Traitement" method="post" style="display: inline;">
                                <input type="hidden" name="action" value="deleteLaboratoire">
                                <input type="hidden" name="id" value="${lab.id}">
                                <button type="submit" class="btn btn-danger" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce laboratoire ?');">
                                    Supprimer
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
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
