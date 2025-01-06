<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                <!-- Main Content -->
                <div class="jumbotron">
                    <h1>Bienvenue à E-Pharmacie</h1>
                    <p>Utilisez le menu en haut pour insérer des données ou effectuer des recherches.</p>
                </div>
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
