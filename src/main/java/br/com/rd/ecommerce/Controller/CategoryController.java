package br.com.rd.ecommerce.Controller;

import br.com.rd.ecommerce.model.Category;
import br.com.rd.ecommerce.model.Product;
import br.com.rd.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController

public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @ResponseStatus(HttpStatus.CREATED)

    @PostMapping("/create-category")
    public Category save(@RequestBody Category category){
        return categoryRepository.save(category);
    }


    @GetMapping("/category/{id}")
    public Category findById(@PathVariable("id") Long idCategory) {
        return categoryRepository.findById(idCategory).get();
    }

    //usando ?id="id"
    @GetMapping("/category")
    public Category findByIdCategory(@PathParam("id") Long id){
        return categoryRepository.findById(id).get();
    }


    @GetMapping("/category/list")
    public List<Category> find(){ return categoryRepository.findAll();}

    @DeleteMapping("/category/{id}")
    public void deletById(@PathVariable("id") Long id){
        categoryRepository.deleteById(id);
    }

    @PutMapping("/category")
    public Category alterar(@RequestBody Category category){
        Category categoryEntity = categoryRepository.getOne(category.getId());
        categoryEntity.setDescription(category.getDescription());
        return  categoryRepository.save(categoryEntity);
    }

}
