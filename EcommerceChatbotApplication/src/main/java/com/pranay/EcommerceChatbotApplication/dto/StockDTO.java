package com.pranay.EcommerceChatbotApplication.dto;

public class StockDTO {
    private String productName;
    private int count;

    public StockDTO(String productName, int count) {
        this.productName = productName;
        this.count = count;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public StockDTO() {
    }
}
