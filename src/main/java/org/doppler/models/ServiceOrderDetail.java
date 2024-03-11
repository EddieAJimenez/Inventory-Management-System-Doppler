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
    private Order orderId;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service serviceId;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    @ManyToOne
    @JoinColumn(name = "service_status_id", nullable = false)
    private ServiceStatus serviceStatusId;
}
