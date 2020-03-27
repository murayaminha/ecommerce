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
    @NotNull
    @NotBlank(message = "Endereço não pode ser branco")
    @Column(name ="ds_logradouro")
    private String logradouro;
    @NotNull
    @Column(name="ds_zipCode")
    @Pattern(regexp = "[0-8]{8}", message = "CEP inválido")
    @Size(max= 8)
    private String zipCode;
    @Column( name="ds_complement")
    private String complement;
    @NotNull
    @NotBlank( message = "Numero da residencia não pode ser branco")
    @Max(6)
    @Column(name ="nr_number")
    private Integer number;
    @NotNull
    @Size(max = 2)
    @Column(name="ds_estate")
    private String state;
    @NotNull
    @NotBlank( message = "Cidade não pode ser branco")
    @Column (name="ds_city", nullable = false)
    private  String city;
    @Column(name = "neighborhood")
    private String neighborhood;
//    @OneToMany(mappedBy = "address")
//    private List<ClientAddress> clientAddress;
}
