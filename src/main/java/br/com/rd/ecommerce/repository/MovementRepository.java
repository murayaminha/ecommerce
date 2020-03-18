package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovementRepository extends JpaRepository<Movement,Long> {
    List<Movement>findByType(Boolean type);
}
