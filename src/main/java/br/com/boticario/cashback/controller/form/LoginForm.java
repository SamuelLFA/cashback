package br.com.boticario.cashback.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
public class LoginForm {

    @JsonProperty("email")
    private String email;
    @JsonProperty("senha")
    private String password;

    public UsernamePasswordAuthenticationToken mapToUsernamePasswordAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
