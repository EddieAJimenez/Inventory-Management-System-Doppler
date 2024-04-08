package org.doppler.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "service_order_detail")
public class ServiceOrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private SaleOrder orderId;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service serviceId;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    @ManyToOne
    @JoinColumn(name = "service_status_id", nullable = false)
    private ServiceStatus serviceStatusId;

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

    public Service getServiceId() {
        return serviceId;
    }

    public void setServiceId(Service serviceId) {
        this.serviceId = serviceId;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public ServiceStatus getServiceStatusId() {
        return serviceStatusId;
    }

    public void setServiceStatusId(ServiceStatus serviceStatusId) {
        this.serviceStatusId = serviceStatusId;
    }
}
