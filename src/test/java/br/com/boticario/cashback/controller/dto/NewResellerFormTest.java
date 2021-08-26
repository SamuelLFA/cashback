package br.com.boticario.cashback.controller.dto;

import br.com.boticario.cashback.controller.form.NewResellerForm;
import br.com.boticario.cashback.model.Reseller;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class NewResellerFormTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void when_form_is_valid_should_return_model() {
        NewResellerForm form = new NewResellerForm();
        form.setName("Reseller");
        form.setDocument("00000000000");
        form.setEmail("email@email.com");
        form.setPassword("123456");

        Reseller reseller = form.toModel(passwordEncoder);
        assertEquals(reseller.getName(), form.getName());
        assertEquals(reseller.getDocument(), form.getDocument());
        assertEquals(reseller.getEmail(), form.getEmail());
    }
}
