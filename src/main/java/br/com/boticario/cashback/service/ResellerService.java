package br.com.boticario.cashback.service;

import br.com.boticario.cashback.model.Reseller;
import br.com.boticario.cashback.repository.ResellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResellerService {

    private final ResellerRepository resellerRepository;

    @Autowired
    public ResellerService(ResellerRepository resellerRepository) {
        this.resellerRepository = resellerRepository;
    }

    public void create(Reseller model) {
        resellerRepository.save(model);
    }
}
