package org.setronica.pim.repository;

import org.setronica.pim.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String name);

    List<Product> findByDescriptionContaining(String description);
}
