package br.com.boticario.cashback.controller.dto;

import br.com.boticario.cashback.controller.form.NewResellerForm;
import br.com.boticario.cashback.model.Reseller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewResellerFormTest {

    @Test
    void when_form_is_valid_should_return_model() {
        NewResellerForm form = new NewResellerForm();
        form.setName("Reseller");
        form.setDocument("00000000000");
        form.setEmail("email@email.com");
        form.setPassword("123456");

        Reseller reseller = form.toModel();
        assertEquals(reseller.getName(), form.getName());
        assertEquals(reseller.getDocument(), form.getDocument());
        assertEquals(reseller.getEmail(), form.getEmail());
    }
}
