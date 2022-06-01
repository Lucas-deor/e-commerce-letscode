package com.letscode.orderapi.domain;

import org.springframework.data.mongodb.core.mapping.Document;


@Document("order-response")
public class OrderResponse {

    private String id;
    private UserResponse userInfo;
    private ProductResponse productInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserResponse getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserResponse userInfo) {
        this.userInfo = userInfo;
    }

    public ProductResponse getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductResponse productInfo) {
        this.productInfo = productInfo;
    }
}

