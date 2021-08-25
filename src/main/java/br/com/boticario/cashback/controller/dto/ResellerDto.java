package br.com.boticario.cashback.controller.dto;

import br.com.boticario.cashback.model.Reseller;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResellerDto {

    @JsonProperty("nome_completo")
    private String name;

    @JsonProperty("cpf")
    private String document;

    @JsonProperty("email")
    private String email;

    public ResellerDto(Reseller model) {
        this.name =  model.getName();
        this.document = model.getDocument();
        this.email = model.getEmail();
    }
}
