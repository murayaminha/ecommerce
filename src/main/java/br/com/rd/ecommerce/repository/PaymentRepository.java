package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface PaymentRepository extends JpaRepository<Payment, Long>{
    List<Payment>findByStatus(String status);

}
