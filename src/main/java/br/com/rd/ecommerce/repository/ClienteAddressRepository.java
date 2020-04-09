package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.Address;
import br.com.rd.ecommerce.model.Client;
import br.com.rd.ecommerce.model.ClientAddress;
import br.com.rd.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteAddressRepository extends JpaRepository<ClientAddress, Long> {

    List<ClientAddress> findByClient(Client client);

    @Query(value = "SELECT address FROM ClientAddress where client = :cliente",
            nativeQuery = true)
    List<Address> findAddressClient(@Param("cliente")Client cliente);
}
