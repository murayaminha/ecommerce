package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.Client;
import br.com.rd.ecommerce.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    CreditCard findByClient (Client client);
}
