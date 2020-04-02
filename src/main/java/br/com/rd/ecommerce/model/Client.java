package br.com.rd.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dom4j.tree.AbstractEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_client", uniqueConstraints ={@UniqueConstraint( columnNames = "ds_mail", name = "ds_cpf")} )
public class Client  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long idClient;
    @Column(name = "ds_name")
    private  String name;
    @Column(name = "ds_cpf")
    private String cpf;
    @Column(name = "dt_birth")
    private Date birthDate;
    @Column(name="ds_mail")
    private  String mail;
    @Column(name="ds_password")
    private String password;
    @Column(name="nr_phone")
    private String phone;
    private boolean user;
    private boolean admin;



//    @OneToMany(mappedBy = "client")
//    private List<ClientAddress> clientAddress;

}