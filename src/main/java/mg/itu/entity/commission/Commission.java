package mg.itu.entity.commission;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mg.itu.entity.vente.Vente;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Commission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "vente_id",nullable = false)
    Vente vente;

    @Column(nullable = false)
    Double commission;

    @Column(nullable = false)
    LocalDateTime date;





}
