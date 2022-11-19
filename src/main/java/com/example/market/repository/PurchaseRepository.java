package com.example.market.repository;

import com.example.market.models.Purchase;
import com.example.market.models.Product;
import com.example.market.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    List<Purchase> findByUser(User user);
    List<Purchase> findByProduct(Product product);
}
