package br.com.rd.ecommerce.Controller;
import br.com.rd.ecommerce.model.Address;
import br.com.rd.ecommerce.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@RestController

public class AddressController {
    @Autowired
    private AddressRepository addressRepository;
    private Address address;
    @PersistenceContext
    private EntityManager em;
    @ResponseStatus(HttpStatus.CREATED)

    @PostMapping("/create-address")
    public Address save(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    @GetMapping("/find-address/list")
    public List<Address> find() {return addressRepository.findAll();}

    @GetMapping("find-lastAddress")
    public Long findLast(){return addressRepository.max();}
}