package com.pranay.EcommerceChatbotApplication.Repository;

import com.pranay.EcommerceChatbotApplication.Model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemRepo extends JpaRepository<InventoryItem,Long> {
    @Query("SELECT COUNT(i) FROM InventoryItem i WHERE LOWER(i.productName)= LOWER(:productName) AND i.soldAt IS NULL")
    int countByProductNameAndSoldAtIsNull(String productName);
}
