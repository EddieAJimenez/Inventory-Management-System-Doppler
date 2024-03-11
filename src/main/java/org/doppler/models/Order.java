package org.doppler.models;

import jakarta.persistence.*;
import org.hibernate.type.NumericBooleanConverter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {
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
    private Boolean requiresInstallation;

    @OneToMany(mappedBy = "orderId")
    private List<ProductOrderDetail> orderProducts;

    @OneToMany(mappedBy = "orderId")
    private List<ServiceOrderDetail> orderServices;
}
