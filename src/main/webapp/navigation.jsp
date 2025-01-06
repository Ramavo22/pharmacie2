<%--
  Created by IntelliJ IDEA.
  User: nyxra
  Date: 06/01/2025
  Time: 08:37
  To change this template use File | Settings | File Templates.
--%>

<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!-- Header -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-menu" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">Pharmacie</a>
        </div>

        <!-- Menu -->
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
