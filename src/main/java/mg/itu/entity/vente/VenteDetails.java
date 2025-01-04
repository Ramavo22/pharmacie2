package mg.itu.entity.vente;

import javax.annotation.processing.Generated;

import jakarta.persistence.*;
import lombok.Data;
import mg.itu.entity.Produit;

@Entity
@Data
public class VenteDetails {
    /*
     * Corps de la classe VenteDetails
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "vente_id", nullable = false)
    Vente vente;

    @ManyToOne
    @JoinColumn(name = "produit_id", nullable = false)
    Produit produit;

    @Column(nullable = false)
    Integer quantite;

    @Column(nullable = false)
    Double prixUnitaire;

    /*
     * Calcul automatique (quantite * prixUnitaire)
     */
    @Column(nullable = false)
    Double prixTotal;

}
