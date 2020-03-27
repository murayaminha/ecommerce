package br.com.rd.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long id;

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
    private Number phone;

//    @OneToMany(mappedBy = "client")
//    private List<ClientAddress> clientAddress;

}