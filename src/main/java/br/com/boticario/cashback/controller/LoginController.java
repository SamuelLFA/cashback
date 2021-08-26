package br.com.boticario.cashback.controller;

import br.com.boticario.cashback.controller.dto.TokenDto;
import br.com.boticario.cashback.controller.form.LoginForm;
import br.com.boticario.cashback.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
@Profile(value = {"prod", "test"})
public class LoginController {

    private final TokenService tokenService;

    private final AuthenticationManager authManager;

    @Autowired
    public LoginController(TokenService tokenService, AuthenticationManager authManager) {
        this.tokenService = tokenService;
        this.authManager = authManager;
    }

    @PostMapping
    public ResponseEntity<TokenDto> authenticate(@RequestBody @Valid LoginForm form) {
        var loginData = form.mapToUsernamePasswordAuthenticationToken();

        try {
            var authentication = authManager.authenticate(loginData);
            var token = tokenService.createToken(authentication);

            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
