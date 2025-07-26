package com.pranay.EcommerceChatbotApplication.dto;

public class OrderStatusDTO {
    private Long orderId;
    private String status;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderStatusDTO(Long orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public OrderStatusDTO() {
    }
}
