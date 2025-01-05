package mg.itu.exception;

public class ProduitNotFoundException extends RuntimeException {
    public ProduitNotFoundException() {
        super("Produit not trouvée");
    }
}
