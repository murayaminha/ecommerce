package br.com.rd.ecommerce.Controller;

import br.com.rd.ecommerce.model.Category;
import br.com.rd.ecommerce.model.Product;
import br.com.rd.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController

public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/create-product")
    public Product save(@RequestBody Product product){
        return productRepository.save(product);
    }



    @GetMapping("/find-product")
    public ResponseEntity <List<Product>> findProducts(){
        return ResponseEntity.ok().body(productRepository.findAll());
    }


    @GetMapping("/find-product/list")
    public List<Product> find(){ return productRepository.findAll();
    }

    @GetMapping("/product-id/{codProduct}")
    public ResponseEntity findById(@PathVariable("codProduct") Long codProduct) {
        return ResponseEntity.ok().body(productRepository.findByCodProduct(codProduct));
    }

    @GetMapping("/product-id-description")

    public ResponseEntity<List<Product>> findByIdDescrition(@PathParam("codProduct") Long codProduct,
                                                            @PathParam("description") String description){
       List<Product> products = new ArrayList<>();

        if (codProduct != null && description != null){
            products = productRepository.findByCodProductAndDescription(codProduct,description);
        }else if(codProduct != null){
            products.add(productRepository.findById(codProduct).get());
        }else if(description != null){
            products = productRepository.findByDescription(description);
        }

        if (products != null && products.size() > 0){
            return ResponseEntity.ok().body(products);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/product-orderName")
    public List<Product> findOrderName(){
        return productRepository.findByOrderByName();
    }

    @GetMapping("/product-orderPrice")
    public List<Product> findOrderPrice(){
        return productRepository.findByOrderByValueProduct();
    }
    @GetMapping("/product-orderNameDesc")
    public List<Product> findOrderNameDesc(){
        return productRepository.findByOrderByNameDesc();
    }

    @GetMapping("/product-orderPriceDesc")
    public List<Product> findOrderPriceDesc(){
        return productRepository.findByOrderByValueProductDesc();
    }

    @GetMapping("/product-description/{description}")
    public List<Product> findByDescription(@PathVariable("description") String description){
        return productRepository.findByDescription(description);
    }

    @DeleteMapping("/product")
    public void deletById(@PathVariable("id") Long id){
        productRepository.deleteById(id);
    }


    @PutMapping("/product")
    public Product alterar(@RequestBody Product product){
        Product productEntity = productRepository.getOne(product.getCodProduct());
        productEntity.setCategory(product.getCategory());
        productEntity.setCodProduct(product.getCodProduct());
        productEntity.setValueProduct(product.getValueProduct());
        productEntity.setDescription(product.getDescription());
        productEntity.setBrand(product.getBrand());
        productEntity.setModel(product.getModel());
        return productRepository.save(productEntity);
    }


    @GetMapping("/product-category/{category}")
    public List<Product> findByCategory(@PathVariable("category")Category category){
        return productRepository.findByCategory(category);
    }
}