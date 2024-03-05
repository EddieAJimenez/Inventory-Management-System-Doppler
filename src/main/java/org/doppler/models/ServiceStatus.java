package org.doppler.models;

import jakarta.persistence.*;

@Entity
@Table(name = "service_status")
public class ServiceStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "service_status_name", nullable = false)
    private String serviceStatusName;

    public ServiceStatus() {
    }

    public ServiceStatus(String serviceStatusName) {
        this.serviceStatusName = serviceStatusName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceStatusName() {
        return serviceStatusName;
    }

    public void setServiceStatusName(String serviceStatusName) {
        this.serviceStatusName = serviceStatusName;
    }

    @Override
    public String toString() {
        return "ServiceStatus{" +
                "id=" + id +
                ", serviceStatusName='" + serviceStatusName + '\'' +
                '}';
    }
}
