package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {


}
