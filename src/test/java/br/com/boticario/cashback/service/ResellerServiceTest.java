package br.com.boticario.cashback.service;

import br.com.boticario.cashback.model.Reseller;
import br.com.boticario.cashback.repository.ResellerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ResellerServiceTest {

    @Mock
    ResellerRepository resellerRepository;

    @Test
    void when_model_is_valid_should_success() {
        ResellerService resellerService = new ResellerService(resellerRepository);
        Reseller model = new Reseller(1L, "Reseller", "00000000000", "email@email.com");

        resellerService.create(model);
        Mockito.verify(resellerRepository, Mockito.times(1)).save(model);
    }
}
