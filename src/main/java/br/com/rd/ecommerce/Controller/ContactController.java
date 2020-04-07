package br.com.rd.ecommerce.Controller;

import br.com.rd.ecommerce.model.Client;
import br.com.rd.ecommerce.model.Contact;
import br.com.rd.ecommerce.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ContactController {

    @Autowired
    private ContactRepository repository;
    @ResponseStatus(HttpStatus.CREATED)

//    @PostMapping("/create-contact")
//    public Contact save(@RequestBody Contact contact){
//        return repository.save(contact);   }

    @PostMapping("/create-contact")
    public Contact save(@RequestBody Contact contact){
        return repository.save(contact);
    };
}

