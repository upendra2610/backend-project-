package dev.upendra.productcatalog.controllers;


import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public void getAllProducts(){

    }

    @GetMapping("{id}")
    public String getProductById(@PathVariable("id") Long id){
        return "here is the product id: "+id;
    }

    @DeleteMapping ("{id}")
    public String deleteProductById(@PathVariable("id") Long id){
        return "product deleted";
    }

    @PostMapping()
    public String createProduct(){
        return "created new product:" + UUID.randomUUID();
    }

    @PutMapping
    public void updateProductById(){

    }
}
