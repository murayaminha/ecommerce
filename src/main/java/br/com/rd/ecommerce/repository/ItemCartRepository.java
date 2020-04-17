package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.ItemCart;
import br.com.rd.ecommerce.model.Product;
import br.com.rd.ecommerce.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository

public interface ItemCartRepository extends JpaRepository<ItemCart,Long> {

    List<ItemCart> findByValueProduct(BigDecimal ValueProduct);
    List<ItemCart> findByValueFreight(BigDecimal ValueFreight);
    List<ItemCart> findByAmount(Integer Amount);
    List<ItemCart> findByCodProduct(Integer CodProduct);
    List<ItemCart> findByRequest(Request Request);

 @Query(value ="SELECT SUM(amount) AS total, codProduct As prod FROM ItemCart GROUP BY prod ORDER BY total DESC")
//    "select cod_product , sum(ds_amount) as total from tb_cart_item group by cod_product order by total"
    List<?> findOrderRequest();
}
