package br.com.boticario.cashback.controller.form;

import br.com.boticario.cashback.model.Reseller;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    public Reseller toModel(PasswordEncoder passwordEncoder) {
        var reseller = new Reseller();
        reseller.setName(name);
        reseller.setDocument(document);
        reseller.setPassword(passwordEncoder.encode(password));
        reseller.setEmail(email);

        return reseller;
    }
}
