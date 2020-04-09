package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.StatusRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRequestRepository extends JpaRepository<StatusRequest, Long> {
}
