package br.com.boticario.cashback.controller.form;

import br.com.boticario.cashback.model.Reseller;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class NewResellerForm {

    @NotNull @NotEmpty @Length(min = 1, max = 50)
    @JsonProperty("nome_completo")
    private String name;

    @NotNull @NotEmpty @CPF
    @JsonProperty("cpf")
    private String document;

    @NotNull @NotEmpty @Email
    @JsonProperty("email")
    private String email;

    @NotNull @NotEmpty @Length(min = 6, max = 30)
    @JsonProperty("senha")
    private String password;

    public Reseller toModel() {
        return new Reseller(
                null,
                name,
                document,
                email
        );
    }
}
