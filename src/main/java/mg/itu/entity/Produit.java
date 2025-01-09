package mg.itu.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit {  
    /*
     * Corps de la classe Produit
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String label;

    @Column(nullable = false)
    Double prix;

    @ManyToOne
    @JoinColumn(name = "type_produit_id", nullable = false)
    TypeProduit typeProduit;

    @ManyToOne
    @JoinColumn(name = "laboratoire_id", nullable = true)
    Laboratoire laboratoire;

    @ManyToOne
    @JoinColumn(name = "type_personne_id")
    TypePersonne typePersonne;


    @ManyToOne
    @JoinColumn(name="usage_id")
    Usage usage;
    /*
     * Denormalisation du stock
     */
    @Column(nullable = false)
    Integer enStock;
    /*
     * One To Many
     */
    @OneToMany(mappedBy = "produit",fetch = FetchType.LAZY)
    List<MedicamentMaladieNonCompatible> medicamentMaladieNonCompatibles;

    @OneToMany(mappedBy = "produit",fetch = FetchType.LAZY)
    List<MedicamentMaladie> medicamentMaladies;
}
