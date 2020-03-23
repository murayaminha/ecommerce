package br.com.rd.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_client", uniqueConstraints ={@UniqueConstraint( columnNames = "ds_mail", name = "ds_cpf")}    )
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long idClient;

    @NotNull
    @Column(name = "ds_name")
    private  String name;
    @NotNull
    @Column(name = "ds_cpf")
    private String cpf;
    @NotNull
    @Column(name = "dt_birth")
    private Date birthDate;
    @NotNull
    @Column(name="ds_mail")
    private  String mail;
    @NotNull
    @Column(name="ds_password")
    private String password;
    @NotNull
    @Column(name="nr_phone")
    private Integer phone;

//    @OneToMany(mappedBy = "client")
//    private List<ClientAddress> clientAddress;

}