package mg.itu.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
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
    /*
     * Denormalisation du stock
     */
    @Column(nullable = false)
    Integer enStock;
    /*
     * One To Many
     */
    @OneToMany(mappedBy = "produit",fetch = FetchType.EAGER)
    List<MedicamentMaladieNonCompatible> medicamentMaladieNonCompatibles;

    @OneToMany(mappedBy = "produit",fetch = FetchType.EAGER)
    List<MedicamentMaladie> medicamentMaladies;
}
