<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insertion Type Produit</title>
    <link href="assets/styles.css" rel="stylesheet">
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-menu" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">Pharmacie</a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-menu">
                <ul class="nav navbar-nav">
                    <li><a href="index.jsp">Accueil</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Insertion/Recherche <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="insertLaboratoire.jsp">Insertion Laboratoire</a></li>
                            <li><a href="insertTypeProduit.jsp">Insertion Type Produit</a></li>
                            <li><a href="insertMaladie.jsp">Insertion Maladie</a></li>
                            <li><a href="recherche.jsp">Recherche</a></li>
                        </ul>
                    </li>
                    <li><a href="#">À propos</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Main Content -->
    <div class="container">
        <div class="jumbotron">
            <h1>Insertion Type Produit</h1>
            <p>Remplissez le formulaire ci-dessous pour ajouter un nouveau Type de Produit.</p>

            <form action="Traitement" method="post">
                <div class="form-group">
                    <input type="hidden" name="action" value="saveLaboratoire">
                    <label for="nom">Nom du Type Produit :</label>
                    <input type="text" class="form-control" id="nom" name="label" required>
                </div>
               
                <button type="submit" class="btn btn-primary">Ajouter</button>
            </form>
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
