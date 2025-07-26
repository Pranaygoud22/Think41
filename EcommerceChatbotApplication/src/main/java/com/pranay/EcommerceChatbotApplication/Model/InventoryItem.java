package com.pranay.EcommerceChatbotApplication.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class InventoryItem {
    @Id
    private Long id;

    private Long productId;
    private LocalDateTime createdAt;
    private LocalDateTime soldAt;
    private Double cost;

    private String productCategory;
    private String productName;
    private String productBrand;
    private Double productRetailPrice;
    private String productDepartment;
    private String productSku;

    private Long productDistributionCenterId;

    public InventoryItem(Long id, Long productId, LocalDateTime createdAt, LocalDateTime soldAt, Double cost, String productCategory, String productName, String productBrand, Double productRetailPrice, String productDepartment, String productSku, Long productDistributionCenterId) {
        this.id = id;
        this.productId = productId;
        this.createdAt = createdAt;
        this.soldAt = soldAt;
        this.cost = cost;
        this.productCategory = productCategory;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productRetailPrice = productRetailPrice;
        this.productDepartment = productDepartment;
        this.productSku = productSku;
        this.productDistributionCenterId = productDistributionCenterId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getSoldAt() {
        return soldAt;
    }

    public void setSoldAt(LocalDateTime soldAt) {
        this.soldAt = soldAt;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public Double getProductRetailPrice() {
        return productRetailPrice;
    }

    public void setProductRetailPrice(Double productRetailPrice) {
        this.productRetailPrice = productRetailPrice;
    }

    public String getProductDepartment() {
        return productDepartment;
    }

    public void setProductDepartment(String productDepartment) {
        this.productDepartment = productDepartment;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public Long getProductDistributionCenterId() {
        return productDistributionCenterId;
    }

    public void setProductDistributionCenterId(Long productDistributionCenterId) {
        this.productDistributionCenterId = productDistributionCenterId;
    }
}
