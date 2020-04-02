package br.com.rd.ecommerce.Controller;

import br.com.rd.ecommerce.model.Address;
import br.com.rd.ecommerce.model.Client;
import br.com.rd.ecommerce.model.ClientAddress;
import br.com.rd.ecommerce.repository.AddressRepository;
import br.com.rd.ecommerce.repository.ClientRepository;
import br.com.rd.ecommerce.repository.ClienteAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

public class ClientAddressController {

    @Autowired
    private ClienteAddressRepository repository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @ResponseStatus(HttpStatus.CREATED)

    @PostMapping("/create-client-address")
    public ResponseEntity save(@RequestBody ClientAddress clientAddress){
        clientAddress.setClient(clientRepository.save(clientAddress.getClient()));
        clientAddress.setAddress(addressRepository.save(clientAddress.getAddress()));
        repository.save(clientAddress);
        return ResponseEntity.ok().body(clientAddress.getClient());
    };
//    public ClientAddress save(@RequestBody ClientAddress clientAddress){
//        return repository.save(clientAddress);
//    };

    @PostMapping("find-Client-Address")
    public ResponseEntity <?> find(@RequestBody Client client){
        return ResponseEntity.ok().body(repository.findByClient(client).getAddress());
    }

    @GetMapping("/find-client-address/list")
    public List<ClientAddress> find() {
        return repository.findAll();
    }

}
