package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository <Contact, Long> {
    List<Contact>findBySubject(String subject);
    List<Contact>findByMail(String mail);
}
