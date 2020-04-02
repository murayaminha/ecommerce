package br.com.rd.ecommerce.Controller;


import br.com.rd.ecommerce.model.ItemCart;
import br.com.rd.ecommerce.model.User;
import br.com.rd.ecommerce.repository.ItemCartRepository;
import br.com.rd.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


public class ItemCartController {
    @Autowired
    private ItemCartRepository itemCartRepository;

        @PostMapping("/create-itemcart")
    public ItemCart save(@RequestBody ItemCart itemCart){
        return itemCartRepository.save(itemCart);
    }

    @GetMapping("/find-itemcart/list")
    public List<ItemCart> find() {return itemCartRepository.findAll();
    }
}
