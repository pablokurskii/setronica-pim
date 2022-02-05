package org.setronica.setronicapim.services;

import org.setronica.setronicapim.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(long id);

    Product findByName(String name);

    Product findRandom();

    Product save(Product client);
}
