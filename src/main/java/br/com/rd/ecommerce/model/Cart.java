package br.com.rd.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_cart")

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cart")
    private Integer codRequest;

    @Column(name="dt_request")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtRequest;

    @ManyToOne
    @JoinColumn(name="id_client")
    private Client client;

    @Column(name = "vl_request")
    private BigDecimal valueRequest;

    @Column(name = "vl_freight")
    private BigDecimal valueFreight;

    @Column(name = "ds_format_pay")
    private String formatPay;

//    @OneToMany(mappedBy = "request")
//    private List<ItemCart> items;


}
