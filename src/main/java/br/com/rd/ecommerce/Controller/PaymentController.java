package br.com.rd.ecommerce.Controller;

import br.com.rd.ecommerce.model.Payment;
import br.com.rd.ecommerce.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentRepository repository;


    @PostMapping("/payment")
    public Payment save(@RequestBody Payment payment){
        return repository.save(payment);
    }


    @GetMapping("/payment/{id}")
    public Payment findId(@PathVariable("id") Long id) { return repository.findById(id).get();
    }


    @GetMapping("/payment/{status}")
    public List<Payment> findStatus(@PathVariable("status") String status){
        return repository.findByStatus(status);
    }

    @DeleteMapping("/payment")
    public void deletById(@PathVariable("id") Long id){
        repository.deleteById(id);
    }


    @PutMapping("/payment")
    public Payment alterar(@RequestBody Payment payment){
        Payment movement1 = repository.getOne(payment.getId());
        movement1.setStatus(payment.getStatus());
        return repository.save(movement1);
    }

}
