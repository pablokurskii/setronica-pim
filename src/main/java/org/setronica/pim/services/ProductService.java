package org.setronica.pim.services;

import org.setronica.pim.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAll();

    void save(Product product);

    Product get(long id);

    List<Product> getByName(String name);

    List<Product> getByDescription(String description);

    void delete(long id);

    List<Product> getAll();
}
