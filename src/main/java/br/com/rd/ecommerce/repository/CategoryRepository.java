package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface CategoryRepository extends JpaRepository<Category,Long> {

    List<Category> findByDescription(String Description);
}
