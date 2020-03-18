package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository

public interface ClientRepository extends JpaRepository<Client,Long> {
    List<Client> findByName(String Name);
    List<Client> findByCpf(String cpf);
    List<Client> findByBirthDate(Integer birth);
    List<Client> findByMail(String mail);
    List<Client> findByPassword(String password);
    List<Client> findByPhone(Number phone);
}