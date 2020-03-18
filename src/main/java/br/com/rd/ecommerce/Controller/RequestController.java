package br.com.rd.ecommerce.Controller;


import br.com.rd.ecommerce.model.Payment;
import br.com.rd.ecommerce.model.Request;
import br.com.rd.ecommerce.repository.PaymentRepository;
import br.com.rd.ecommerce.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestController {

    @Autowired
    private RequestRepository repository;


    @PostMapping("/repository")
    public Request save(@RequestBody Request request){
        return repository.save(request);
    }


    @GetMapping("/repository/{id}")
    public Request findId(@PathVariable("id") Long id) { return repository.findById(id).get();
    }


    @DeleteMapping("/repository")
    public void deletById(@PathVariable("id") Long id){
        repository.deleteById(id);
    }


}
