package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.ClientAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteAddressRepository extends JpaRepository<ClientAddress, Long> {


}
