package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.Client;
import br.com.rd.ecommerce.model.ClientAddress;
import br.com.rd.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteAddressRepository extends JpaRepository<ClientAddress, Long> {

    ClientAddress findByClient(Client client);

}
