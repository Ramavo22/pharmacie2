package mg.itu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import mg.itu.entity.vente.Vente;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommissionVendeurDTO {
    Vente vente;
    Double commission;
}
