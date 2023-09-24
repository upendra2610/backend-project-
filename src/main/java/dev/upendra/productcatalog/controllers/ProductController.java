package dev.upendra.productcatalog.controllers;


import dev.upendra.productcatalog.dtos.GenericProductDto;
import dev.upendra.productcatalog.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productservice;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productservice){
        this.productservice = productservice;
    }

//    @GetMapping
//    public void getAllProducts(){}
        @GetMapping("{id}")
        public GenericProductDto getProductById(@PathVariable("id") Long id){
            return productservice.getProductById(id);

        }

    @PostMapping()
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
        return productservice.createProduct(product);

//        return "created new product:" + UUID.randomUUID();
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productservice.getAllProducts();
    }





//    @GetMapping("{id}")
//    public String getProductById(@PathVariable("id") Long id){
//        return "here is the product id: "+id;
//    }






//    @DeleteMapping ("{id}")
//    public String deleteProductById(@PathVariable("id") Long id){
//        return "product deleted";
//    }
//
//    @PostMapping()
//    public String createProduct(){
//        return "created new product:" + UUID.randomUUID();
//    }
//
//    @PutMapping
//    public void updateProductById(){
//
//    }
}
