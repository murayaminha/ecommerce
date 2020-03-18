package br.com.rd.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_category")

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_CATEGORY")
    private Long id;


    @Column(name = "ds_category" ,nullable = false)
    private String description;


//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
//    private List<Product> product = new ArrayList<>();

  }

