package com.pranay.EcommerceChatbotApplication.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Long orderId;

    private Long userId;
    private String status;
    private String gender;

    private LocalDateTime createdAt;
    private LocalDateTime returnedAt;
    private LocalDateTime shippedAt;
    private LocalDateTime deliveredAt;

    private Integer numOfItem;

    public Order(Long orderId, Long userId, String status, String gender, LocalDateTime createdAt, LocalDateTime returnedAt, LocalDateTime shippedAt, LocalDateTime deliveredAt, Integer numOfItem) {
        this.orderId = orderId;
        this.userId = userId;
        this.status = status;
        this.gender = gender;
        this.createdAt = createdAt;
        this.returnedAt = returnedAt;
        this.shippedAt = shippedAt;
        this.deliveredAt = deliveredAt;
        this.numOfItem = numOfItem;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(LocalDateTime returnedAt) {
        this.returnedAt = returnedAt;
    }

    public LocalDateTime getShippedAt() {
        return shippedAt;
    }

    public void setShippedAt(LocalDateTime shippedAt) {
        this.shippedAt = shippedAt;
    }

    public LocalDateTime getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(LocalDateTime deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public Integer getNumOfItem() {
        return numOfItem;
    }

    public void setNumOfItem(Integer numOfItem) {
        this.numOfItem = numOfItem;
    }
}
