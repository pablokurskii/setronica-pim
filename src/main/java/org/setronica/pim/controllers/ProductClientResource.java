package org.setronica.pim.controllers;

import org.setronica.pim.domain.Product;
import org.setronica.pim.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
public class ProductClientResource {
    private final ProductService service;
    private static final Logger logger = LoggerFactory.getLogger(ProductClientResource.class);


    public ProductClientResource(ProductService service) {
        this.service = service;
    }

    @GetMapping("/api/product/{id}")
    public Product getProductById(@PathVariable(name = "id") long id,
                                  @RequestParam(required = true, name = "language") String language,
                                  @RequestParam(required = true, name = "currency") String currency) {
        /*TODO search match currency/language in name&description*/
        return service.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/product", params = "name")
    public List<Product> getProductByName(@RequestParam(name = "name") String name,
                                          @RequestParam(required = true, name = "language") String language,
                                          @RequestParam(required = true, name = "currency") String currency,
                                          Model model) {
        return service.getByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/product", params = "description")
    public List<Product> getProductByDescription(@RequestParam(name = "description") String description,
                                                 @RequestParam(required = true, name = "language") String language,
                                                 @RequestParam(required = true, name = "currency") String currency,
                                                 Model model) {
        return service.getByDescription(description);
    }

    @GetMapping("/api/products")
    public List<Product> getProducts(@RequestParam(required = true, name = "language") String language,
                                     @RequestParam(required = true, name = "currency") String currency) {
        return service.getAll();
    }

    @ControllerAdvice
    public static class CustomExceptionHandler {

        @ExceptionHandler
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ResponseBody
        Map<String, String> showCustomMessage(Exception e) {
            logger.error("exception log:", e);

            Map<String, String> response = new HashMap<>();
            response.put("errorCode", Integer.toString(HttpStatus.BAD_REQUEST.value()));
            response.put("errorMessage", HttpStatus.BAD_REQUEST.getReasonPhrase());

            return response;
        }

        @ExceptionHandler
        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ResponseBody
        Map<String, String> showCustomMessage(NoSuchElementException e) {
            logger.error("exception log:", e);

            Map<String, String> response = new HashMap<>();
            response.put("errorCode", Integer.toString(HttpStatus.NOT_FOUND.value()));
            response.put("errorMessage", HttpStatus.NOT_FOUND.getReasonPhrase());

            return response;
        }
    }
}
