package br.com.rd.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


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
    @NotNull
    @Column(name ="ds_logradouro")
    private String logradouro;
    @NotNull
    @Column(name="ds_zipCode")
    private String zipCode;

    @Column( name="ds_complement")
    private String complement;
    @NotNull
    @Column(name ="nr_number")
    private Integer number;
    @NotNull
    @Column(name="ds_estate")
    private String state;
    @NotNull
    @Column (name="ds_city", nullable = false)
    private  String city;
    @Column(name = "neighborhood")
    private String neighborhood;
//    @OneToMany(mappedBy = "address")
//    private List<ClientAddress> clientAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    private Provider provider;
}
