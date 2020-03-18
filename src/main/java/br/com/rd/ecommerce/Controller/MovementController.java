package br.com.rd.ecommerce.Controller;

import br.com.rd.ecommerce.model.Movement;
import br.com.rd.ecommerce.model.Product;
import br.com.rd.ecommerce.repository.MovementRepository;
import br.com.rd.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
@RestController
public class MovementController {


    @Autowired
    private MovementRepository repository;


    @PostMapping("/movement")
    public Movement save(@RequestBody Movement movement){
        return repository.save(movement);
    }


    @GetMapping("/movement/{id}")
    public Movement findId(@PathVariable("id") Long id) {
        return repository.findById(id).get();
    }


    @GetMapping("/movement/{type}")
    public List<Movement> findType(@PathVariable("type") Boolean type){
        return repository.findByType(type);
    }

    @DeleteMapping("/movement")
    public void deletById(@PathVariable("id") Long id){
        repository.deleteById(id);
    }


    @PutMapping("/movement")
    public Movement alterar(@RequestBody Movement movement){
        Movement movement1 = repository.getOne(movement.getId());
        movement1.setType(movement.getType());
        return repository.save(movement1);
    }
}
