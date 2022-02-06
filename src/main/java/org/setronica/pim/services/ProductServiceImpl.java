package org.setronica.pim.services;

import org.setronica.pim.domain.Product;
import org.setronica.pim.repository.ProductRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repo;

    @Override
    public List<Product> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(Product product) {
        repo.save(product);
    }

    @Override
    public Product get(long id) {
        return repo.findById(id).get();
    }

    public List<Product> getByName(String name) {
        return repo.findByNameContaining(name);
    }

    public List<Product> getByDescription(String description) {
        return repo.findByDescriptionContaining(description);
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }
}
