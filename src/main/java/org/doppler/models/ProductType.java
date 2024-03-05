package org.doppler.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_type")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_type_desc", nullable = false)
    private String productTypeName;

    public ProductType() {
    }

    public ProductType(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", productTypeName='" + productTypeName + '\'' +
                '}';
    }
}
