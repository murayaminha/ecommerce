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
@Table(name = "tb_credit_card")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credit_card")
    private Long idCreditCard;
    @OneToOne
    @JoinColumn(name = "id_client")
    private Client client;
    @Column(name = "nr_number_card")
    private String numberCard;
    @Column(name="ds_nome_titular")
    private String nomeTitular;
    @Column(name="ds_cpf_titular")
    private String cpfTitular;
}
