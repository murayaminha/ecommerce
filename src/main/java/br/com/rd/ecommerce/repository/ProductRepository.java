package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.Category;
import br.com.rd.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByCodProduct(Long CodProduct);
    List<Product> findByDescription (String Description);
    List<Product> findByCategory (Category Category);
    List<Product> findByValueProduct (BigDecimal ValueProduct);
    List<Product> findByBrand(String Brand);
    List<Product> findByModel(String Model);
    public List<Product> findByCodProductAndDescription(Long codProduct,String description);
    List<Product> findByOrderByName();
    List<Product> findByOrderByNameDesc();
    List<Product> findByOrderByValueProduct();
    List<Product> findByOrderByValueProductDesc();
}
