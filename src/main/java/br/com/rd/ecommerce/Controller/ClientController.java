package br.com.rd.ecommerce.Controller;
import br.com.rd.ecommerce.model.Client;
import br.com.rd.ecommerce.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @ResponseStatus(HttpStatus.CREATED)

    @PostMapping("/create-client")
    public Client save(@RequestBody Client client){
        return clientRepository.save(client);
    };


    @GetMapping("/find-client/list")
    public List<Client> find() {
        return clientRepository.findAll();
    }
}