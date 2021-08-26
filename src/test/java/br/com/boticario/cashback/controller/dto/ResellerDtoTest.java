package br.com.boticario.cashback.controller.dto;

import br.com.boticario.cashback.model.Reseller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResellerDtoTest {

    @Test
    void when_model_is_valid_should_instantiates() {
        Reseller model = new Reseller();
        model.setId(1L);
        model.setName("Reseller");
        model.setDocument("00000000000");
        model.setEmail("email@email.com");
        model.setPassword("123456");
        ResellerDto resellerDto = new ResellerDto(model);

        assertEquals(resellerDto.getName(), model.getName());
        assertEquals(resellerDto.getDocument(), model.getDocument());
        assertEquals(resellerDto.getEmail(), model.getEmail());
    }
}
