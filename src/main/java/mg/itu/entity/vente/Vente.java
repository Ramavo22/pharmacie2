package mg.itu.entity.vente;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import mg.itu.entity.produit.Produit;

@Entity
@Data
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    LocalDateTime dateVente;

    @ManyToOne
    @JoinColumn(name = "produit_id" , nullable = false)
    Produit produit;

    @Column(nullable = false)
    Integer quantite;

    @Column(nullable = false)
    Double prixUnitaire;
}
