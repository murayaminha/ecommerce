package br.com.rd.ecommerce.Controller;

import br.com.rd.ecommerce.model.Invoice;
import br.com.rd.ecommerce.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController


public class InvoiceController {
    @Autowired
    private InvoiceRepository repository;

    @ResponseStatus(HttpStatus.CREATED)

    @PostMapping("/invoice")
    public Invoice save(@RequestBody Invoice invoice){
        return repository.save(invoice);
    }

    //usando ?id="id"
    @GetMapping("/invoice")
    public Invoice findById(@PathParam("id") Long id){
        return repository.findById(id).get();
    }

    @DeleteMapping("/invoice/{id}")
    public void deletById(@PathVariable("id") Long id){
        repository.deleteById(id);
    }
}
