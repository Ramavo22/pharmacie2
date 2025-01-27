package mg.itu.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;
import mg.itu.entity.produit.Produit;

@Entity
@Data
public class MedicamentMaladieNonCompatible {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "medicament_id", nullable = false)
    Produit produit;
    
    @ManyToOne
    @JoinColumn(name = "maladie_id", nullable = false)
    Maladie maladie;
}
