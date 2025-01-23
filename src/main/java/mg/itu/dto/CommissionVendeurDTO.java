package mg.itu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import mg.itu.entity.vente.Vendeur;
import mg.itu.entity.vente.Vente;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CommissionVendeurDTO {
    Vendeur vendeur;
    Double commission;
}
