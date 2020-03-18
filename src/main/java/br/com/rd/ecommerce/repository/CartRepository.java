package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.Cart;
import br.com.rd.ecommerce.model.Category;
import br.com.rd.ecommerce.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository

public interface CartRepository extends JpaRepository<Cart,Long> {

    List<Cart> findByDtRequest(Date DtRequest);
    List<Cart> findByValueRequest(BigDecimal ValueRequest);
    List<Cart> findByValueFreight(BigDecimal ValueFreight);
    List<Cart> findByFormatPay(String FormatPay);
}
