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
import java.util.ArrayList;
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
    @PostMapping("/save-address")
    public ResponseEntity salvarEndereco(@RequestBody ClientAddress clientAddress){
        clientAddress.setAddress(addressRepository.save(clientAddress.getAddress()));
        repository.save(clientAddress);
        return ResponseEntity.ok().body(clientAddress.getAddress());
    }

    @PostMapping("find-Client-Address")
    public List<Address> find(@RequestBody Client client){
        List<ClientAddress> listaClientes = repository.findByClient(client);
        listaClientes.size();
        List<Address> listaDeEndereco = new ArrayList<>();
        for( int i=0; i<listaClientes.size();i++){
           listaDeEndereco.add( listaClientes.get(i).getAddress());
        }
        return listaDeEndereco;
    }

    @GetMapping("/find-client-address/list")
    public List<ClientAddress> find() {
        return repository.findAll();
    }

    @GetMapping("/find-client-address/{id}")
    public ResponseEntity<?> findId(@PathVariable("id") Long id) {
    return ResponseEntity.ok().body(clientRepository.findById(id));
    }
}
