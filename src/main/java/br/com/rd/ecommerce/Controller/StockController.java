package br.com.rd.ecommerce.Controller;

import br.com.rd.ecommerce.model.Stock;
import br.com.rd.ecommerce.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockRepository repository;


    @PostMapping("/stock")
    public Stock save(@RequestBody Stock stock){
        return repository.save(stock);
    }


    @GetMapping("/stock/{id}")
    public Stock findId(@PathVariable("id") Long id) { return repository.findById(id).get();
    }


    @DeleteMapping("/stock")
    public void deletById(@PathVariable("id") Long id){
        repository.deleteById(id);
    }

}
