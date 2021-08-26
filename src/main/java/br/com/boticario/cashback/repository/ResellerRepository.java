package br.com.boticario.cashback.repository;

import br.com.boticario.cashback.model.Reseller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResellerRepository extends JpaRepository<Reseller, Long> {

    Optional<Reseller> findByEmail(String email);
}
