package dev.upendra.productcatalog.controllers;


import dev.upendra.productcatalog.dtos.ExceptionDto;
import dev.upendra.productcatalog.dtos.GenericProductDto;
import dev.upendra.productcatalog.exceptions.NotFoundExceptions;
import dev.upendra.productcatalog.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

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
        public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundExceptions {
            return productservice.getProductById (id);

        }

        // Any of the method of this controller which services throws notfound exception-
        // this method will automatically called
        @ExceptionHandler(NotFoundExceptions.class)
        private ResponseEntity<ExceptionDto> notFoundExceptionHandler(NotFoundExceptions notFoundExceptions){
              return new ResponseEntity(
                      new ExceptionDto(HttpStatus.NOT_FOUND, notFoundExceptions.getMessage()),
                      HttpStatus.NOT_FOUND

              );
              //We have created meaningful exception with good Http status code
            //better presentation

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


    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProduct(@PathVariable("id") Long id){
        //Returned as a response Entity which has ability to return HttpStatus
        //controller has the info of Http status not in service, controller know info about service status
        return new ResponseEntity<>(productservice.deleteProductById(id), HttpStatus.NOT_FOUND);
//        return productservice.deleteProductById(id);
    }


    @PutMapping("{id}")
    public GenericProductDto updateById(@PathVariable("id") Long id,@RequestBody GenericProductDto product){
        return productservice.updateProduct(id,product);
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
