package br.com.rd.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_invoiceProducts")

public class InvoiceProducts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invoice_products")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_invoice")
    private Invoice invoice;

    @OneToMany
    @JoinColumn(name = "cod_product")
        private List<Product> product;
}
