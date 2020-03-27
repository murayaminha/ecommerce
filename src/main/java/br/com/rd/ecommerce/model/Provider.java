package br.com.rd.ecommerce.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_provider")
public class Provider  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_provider")
    private Long id;
    @Column(name="name")
    @NotBlank(message = "nome não pode ser branco")
    private String name;
    @Column(name = "cnpj")
    private String cnpj;
    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;

}
