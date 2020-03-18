package br.com.rd.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_cart_item")

public class ItemCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @Column(name="vl_product")
    private BigDecimal valueProduct;

    @Column(name="vl_freight")
    private BigDecimal valueFreight;

    @Column(name="amount")
    private  Integer amount;

    @Column(name="cd_product")
    private Integer codProduct;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;
}
