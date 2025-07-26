package com.pranay.EcommerceChatbotApplication.dto;

public class TopProductDTO {
    private String productName;
    private int soldCount;

    public TopProductDTO(String productName, int soldCount) {
        this.productName = productName;
        this.soldCount = soldCount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(int soldCount) {
        this.soldCount = soldCount;
    }

    public TopProductDTO() {
    }
}
