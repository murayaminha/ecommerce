package br.com.rd.ecommerce.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stock")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_movement")
    private Movement movement;

    @OneToMany
    @JoinColumn(name = "cod_product")
    private List<Product> product;
}

