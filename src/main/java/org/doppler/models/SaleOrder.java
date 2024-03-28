package org.doppler.models;

import jakarta.persistence.*;
import org.hibernate.type.NumericBooleanConverter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sale_order")
public class SaleOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "order_status_id", nullable = false)
    private OrderStatus orderStatusId;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(precision = 10, scale = 2)
    private BigDecimal tax;

    @Column(precision = 10, scale = 2)
    private BigDecimal discount;

    @Column(name = "requires_installation", nullable = false)
    @Convert(converter = NumericBooleanConverter.class)
    private boolean requiresInstallation;

    @OneToMany(mappedBy = "orderId")
    private List<ProductOrderDetail> orderProducts;

    @OneToMany(mappedBy = "orderId")
    private List<ServiceOrderDetail> orderServices;

    public SaleOrder() {
    }

    public SaleOrder(Customer customerId, OrderStatus orderStatusId, Date date, BigDecimal total, BigDecimal tax, BigDecimal discount, boolean requiresInstallation) {
        this.customerId = customerId;
        this.orderStatusId = orderStatusId;
        this.date = date;
        this.total = total;
        this.tax = tax;
        this.discount = discount;
        this.requiresInstallation = requiresInstallation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public OrderStatus getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(OrderStatus orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public boolean isRequiresInstallation() {
        return requiresInstallation;
    }

    public void setRequiresInstallation(boolean requiresInstallation) {
        this.requiresInstallation = requiresInstallation;
    }

    public List<ProductOrderDetail> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<ProductOrderDetail> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public List<ServiceOrderDetail> getOrderServices() {
        return orderServices;
    }

    public void setOrderServices(List<ServiceOrderDetail> orderServices) {
        this.orderServices = orderServices;
    }

    @Override
    public String toString() {
        return "SaleOrder{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", orderStatusId=" + orderStatusId +
                ", date=" + date +
                ", total=" + total +
                ", tax=" + tax +
                ", discount=" + discount +
                ", requiresInstallation=" + requiresInstallation +
                '}';
    }

}
