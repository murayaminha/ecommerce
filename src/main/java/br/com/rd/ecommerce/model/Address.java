package br.com.rd.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_address")

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_address")
    private Long idAddress;
    @Column(name ="ds_logradouro")
    private String logradouro;
    @Column(name="ds_zipCode")
    private String zipCode;
    @Column( name="ds_complement")
    private String complement;
    @Column(name ="nr_number")
    private Integer number;
    @Column(name="ds_estate")
    private String state;
    @Column (name="ds_city")
    private  String city;
    @Column(name = "neighborhood")
    private String neighborhood;
//    @OneToMany(mappedBy = "address")
//    private List<ClientAddress> clientAddress;
}
