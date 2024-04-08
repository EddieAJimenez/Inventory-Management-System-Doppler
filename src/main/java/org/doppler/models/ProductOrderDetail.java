package org.doppler.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product_order_detail")
public class ProductOrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product productId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private SaleOrder orderId;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SaleOrder getOrderId() {
        return orderId;
    }

    public void setOrderId(SaleOrder orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
