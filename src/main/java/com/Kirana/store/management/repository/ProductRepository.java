package com.Kirana.store.management.repository;

import com.Kirana.store.management.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product findByName(String name);

    @Modifying
    @Query(value = "UPDATE Product p SET p.stock = :newStock, p.price = :newPrice WHERE p.name = :productName")
    public void updateStockAndPriceByName(@Param("productName") String productName,
                                  @Param("newStock") int newStock,
                                  @Param("newPrice") double newPrice);
}
