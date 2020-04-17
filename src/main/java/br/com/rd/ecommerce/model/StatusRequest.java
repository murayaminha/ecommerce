package br.com.rd.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_status_request")
public class StatusRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status_request")
    private Long idStatusRequest;

    @Column(name = "dt_date")
    private Date date;

    @Column(name = "ds_Status_request")
    private String statusRequest;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_request")
    private Request request;
}
