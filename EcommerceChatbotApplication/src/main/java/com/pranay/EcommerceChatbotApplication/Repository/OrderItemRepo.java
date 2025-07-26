package com.pranay.EcommerceChatbotApplication.Repository;

import com.pranay.EcommerceChatbotApplication.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem,Long> {
    @Query(value = "SELECT p.name, COUNT(oi.product_id) as sold_count " +
            "FROM order_items oi " +
            "JOIN products p ON oi.product_id = p.id " +
            "WHERE oi.status = 'delivered' " +
            "GROUP BY p.name " +
            "ORDER BY sold_count DESC " +
            "LIMIT :limit", nativeQuery = true)
    List<Object[]> findByTopSoldProducts(int limit);
}
