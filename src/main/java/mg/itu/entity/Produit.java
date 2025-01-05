package mg.itu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
