package org.setronica.pim.services;

import org.setronica.pim.domain.Product;
import org.setronica.pim.repository.ProductRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

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

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }
}
