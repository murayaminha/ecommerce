package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.Cart;
import br.com.rd.ecommerce.model.ItemCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository

public interface ItemCartRepository extends JpaRepository<ItemCart,Long> {

    List<ItemCart> findByValueProduct(BigDecimal ValueProduct);
    List<ItemCart> findByValueFreight(BigDecimal ValueFreight);
    List<ItemCart> findByAmount(Integer Amount);
    List<ItemCart> findByCodProduct(Integer CodProduct);
    List<ItemCart> findByRequest(Cart Request);
}
