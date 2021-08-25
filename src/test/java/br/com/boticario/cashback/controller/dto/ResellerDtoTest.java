package br.com.boticario.cashback.controller.dto;

import br.com.boticario.cashback.model.Reseller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResellerDtoTest {

    @Test
    void when_model_is_valid_should_instantiates() {
        Reseller model = new Reseller(1L, "Reseller", "00000000000", "email@email.com");
        ResellerDto resellerDto = new ResellerDto(model);

        assertEquals(resellerDto.getName(), model.getName());
        assertEquals(resellerDto.getDocument(), model.getDocument());
        assertEquals(resellerDto.getEmail(), model.getEmail());
    }
}
