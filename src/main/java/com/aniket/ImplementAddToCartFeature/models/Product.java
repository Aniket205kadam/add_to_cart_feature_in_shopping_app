package com.aniket.ImplementAddToCartFeature.models;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Product {
    private MultipartFile productImage;
    private String productName;
    private Double productPrice;
    private String productDescription;

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productImage=" + productImage +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
