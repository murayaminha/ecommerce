package br.com.rd.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_request")
    private Long id;
    @Column(name="price")
            private BigDecimal price;
    @Column(name="price_freight")
            private BigDecimal priceFreight;

    @OneToMany
    @JsonManagedReference
    @JoinColumn(name = "id_request")
    private List<StatusRequest> statusRequest;

    @Column(name = "dt_date")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
    @OneToOne
    @JoinColumn(name = "id_payment")
    private Payment payment;
    @Column(name = "ds_name_delivery")
    private String name;
    @Column(name = "telefone")
    private String phone;
    @OneToOne
    @JoinColumn (name = "id_address")
    private Address address;



}
