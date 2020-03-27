package br.com.rd.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_product")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codProduct;

    @Column(name="ds_product", nullable = false)
    private String description;

    @Column(name="ds_name")
    private String name;

    @Column(name="ds_image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "CD_CATEGORY")
    private Category category;

    @Column(name = "vl_product", nullable = false)
    private BigDecimal valueProduct;

    @Column(name = "vl_productDiscount")
    private BigDecimal valueDiscount;

    @Column(name ="ds_brand")
    private String brand;

    @Column(name = "ds_model")
    private String model;

    @ManyToOne
    @JoinColumn(name = "stock")
    private Stock stock;

    @ManyToOne
    @JoinColumn(name = "invoiceProducts_id")
    private InvoiceProducts invoiceProducts;

}
