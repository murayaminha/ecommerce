package br.com.rd.ecommerce.Controller;

import br.com.rd.ecommerce.model.Client;
import br.com.rd.ecommerce.model.ClientAddress;
import br.com.rd.ecommerce.repository.ClientRepository;
import br.com.rd.ecommerce.repository.ClienteAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ClientAddressController {

    @Autowired
    private ClienteAddressRepository repository;
    @ResponseStatus(HttpStatus.CREATED)

    @PostMapping("/create-client-address")
    public ClientAddress save(@RequestBody ClientAddress clientAddress){
        return repository.save(clientAddress);
    };

    @GetMapping("/find-client-address/list")
    public List<ClientAddress> find() {
        return repository.findAll();
    }

}
