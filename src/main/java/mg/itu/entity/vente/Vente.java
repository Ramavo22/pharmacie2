package mg.itu.entity.vente;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mg.itu.entity.Client;
import mg.itu.entity.produit.Produit;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    LocalDateTime dateVente;

    @ManyToOne
    @JoinColumn(name = "vendeur_id", nullable = false)
    Vendeur vendeur;

    @ManyToOne
    @JoinColumn(name = "produit_id" , nullable = false)
    Produit produit;

    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    Client client;

    @Column(nullable = false)
    Integer quantite;

    @Column(nullable = false)
    Double prixUnitaire;
}
