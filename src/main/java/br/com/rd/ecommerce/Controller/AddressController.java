package br.com.rd.ecommerce.Controller;
import br.com.rd.ecommerce.model.Address;
import br.com.rd.ecommerce.model.Client;
import br.com.rd.ecommerce.model.ClientAddress;
import br.com.rd.ecommerce.repository.AddressRepository;
import br.com.rd.ecommerce.repository.ClientRepository;
import br.com.rd.ecommerce.repository.ClienteAddressRepository;
import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController

public class AddressController {
    @Autowired
    private AddressRepository addressRepository;
    private Address address;
    @Autowired
   private ClientRepository clientRepository;
    @Autowired
    private ClienteAddressRepository clienteAddressRepository;
    @PersistenceContext
    private EntityManager em;
    @ResponseStatus(HttpStatus.CREATED)

    @PostMapping("/create-address")
    public Address save(@RequestBody Address address){
        return addressRepository.save(address);}

//    @PostMapping("/create-address/{id}")
//    public ResponseEntity<Object> save(@RequestBody Address address,
//                                       @PathVariable("id")Long id ) {
//        Optional<Client> cliente = clientRepository.findById(id);
//        Client opt_cliente = cliente.orElse(null);
//        if (opt_cliente == null) {
//            return ResponseEntity.notFound().build();
//        } else {
//            ClientAddress clientAddress = null;
//            clientAddress.setAddress(address);
//            clientAddress.setClient(opt_cliente);
//            return ResponseEntity.ok().body(clienteAddressRepository.save(clientAddress));
//        }
//    }

    @GetMapping("/find-address/list")
    public List<Address> find() {return addressRepository.findAll();}


    @GetMapping("/find-address/{id}")
    public ResponseEntity findAddressById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(addressRepository.findById(id));
    }

    @GetMapping("find-lastAddress")
    public Long findLast(){return addressRepository.max();}
}