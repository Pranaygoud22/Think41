package com.pranay.EcommerceChatbotApplication.Repository;

import com.pranay.EcommerceChatbotApplication.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
}
