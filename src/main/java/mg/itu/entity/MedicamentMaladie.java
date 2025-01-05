package mg.itu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class MedicamentMaladie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "medicament_id", nullable = false)
    Produit produit;

    @ManyToOne
    @JoinColumn(name = "maladie_id", nullable = false)
    Maladie maladie;

}
