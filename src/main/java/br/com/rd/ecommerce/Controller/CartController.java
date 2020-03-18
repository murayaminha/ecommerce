package br.com.rd.ecommerce.Controller;

import br.com.rd.ecommerce.model.Cart;
import br.com.rd.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/create-cart")
    public Cart save(@RequestBody Cart cart){
        return cartRepository.save(cart);
    }

    @GetMapping("/find-cart/list")
    public List<Cart> find() {
        return cartRepository.findAll();
    }
}