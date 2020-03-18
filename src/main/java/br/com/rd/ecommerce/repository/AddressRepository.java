package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    List<Address> findByLogradouro(String Logradouro);
    List<Address> findByZipCode(String ZipCode);
    List<Address> findByComplement(String Complement);
    List<Address> findByNumber(Number number);
    List<Address> findByState(String State);
    List<Address> findByCity(String City);
}