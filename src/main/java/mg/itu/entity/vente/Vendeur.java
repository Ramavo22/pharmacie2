package mg.itu.entity.vente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mg.itu.entity.Genre;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String name;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    Genre genre;


}
