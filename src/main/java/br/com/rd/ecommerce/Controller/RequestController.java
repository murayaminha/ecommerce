package br.com.rd.ecommerce.Controller;


import br.com.rd.ecommerce.model.Client;
import br.com.rd.ecommerce.model.ClientAddress;
import br.com.rd.ecommerce.model.Payment;
import br.com.rd.ecommerce.model.Request;
import br.com.rd.ecommerce.repository.AddressRepository;
import br.com.rd.ecommerce.repository.ClientRepository;
import br.com.rd.ecommerce.repository.PaymentRepository;
import br.com.rd.ecommerce.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RequestRepository repository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/request")
    public Request save(@RequestBody Request request){
        request.setPayment(paymentRepository.save(request.getPayment()));
        return repository.save(request);
    }
    @GetMapping("/request/{id}")
    public Request findId(@PathVariable("id") Long id) { return repository.findById(id).get();
    }
    @DeleteMapping("/request")
    public void deletById(@PathVariable("id") Long id){
        repository.deleteById(id);
    }

    @PostMapping("/acompanhar")
    public ResponseEntity<List<Request>> acompanhar(@RequestBody() Client user){
            List request = repository.findByClient(user);
                return ResponseEntity.ok().body(request);
}
}
