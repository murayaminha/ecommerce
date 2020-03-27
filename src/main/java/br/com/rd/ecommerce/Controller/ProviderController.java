package br.com.rd.ecommerce.Controller;

import br.com.rd.ecommerce.model.Payment;
import br.com.rd.ecommerce.model.Provider;
import br.com.rd.ecommerce.repository.PaymentRepository;
import br.com.rd.ecommerce.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProviderController {

    @Autowired
    private ProviderRepository repository;


    @PostMapping("/provider")
    public Provider save(@Valid @RequestBody Provider provider){
        return repository.save(provider);
    }


    @GetMapping("/provider/{id}")
    public Provider findId(@PathVariable("id") Long id) { return repository.findById(id).get();
    }


    @GetMapping("/provider/{cnpj}")
    public Provider findCnpj(@PathVariable("cnpj") String cnpj){
        return repository.findByCnpj(cnpj);
    }


    @DeleteMapping("/provider")
    public void deletById(@PathVariable("id") Long id){
        repository.deleteById(id);
    }

}
