package br.com.rd.ecommerce.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ds_name")
    private String name;

    @Column(name = "ds_mail")
    private String mail;

    @Column(name = "ds_subject")
    private String subject;

    @Column(name = "ds_text")
    private String text;
}
