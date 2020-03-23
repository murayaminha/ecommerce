package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    List<Address> findByLogradouro(String Logradouro);
    List<Address> findByZipCode(String ZipCode);
    List<Address> findByComplement(String Complement);
    List<Address> findByNumber(Number number);
    List<Address> findByState(String State);
    List<Address> findByCity(String City);
    @Query(value = "SELECT max(idAddress) FROM Address")
    public Long max();
}