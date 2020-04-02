package br.com.rd.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_cart_item")
public class ItemCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cart_item")
    private Long code;

    @Column(name="vl_product")
    private BigDecimal valueProduct;

    @Column(name="vl_freight")
    private BigDecimal valueFreight;

    @Column(name="ds_amount")
    private  Integer amount;

    @OneToOne
    @JoinColumn(name="cod_product")
    private Product codProduct;

    @ManyToOne
    @JoinColumn(name = "id_request")
    private Request request;
}
