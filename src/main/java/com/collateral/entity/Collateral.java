package com.collateral.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.time.LocalDateTime;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "query_get_all_collateral",
                query = "Select  c  From Collateral c")})

public class Collateral {

    @Id
    private Long id;

    @Column(nullable = false)
    private String collateralType;

    @Column(nullable = true)
    private String valuationStatus;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    public Collateral() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollateralType() {
        return collateralType;
    }

    public void setCollateralType(String collateralType) {
        this.collateralType = collateralType;
    }

    public Collateral(Long id, String collateralType) {
        this.id = id;
        this.collateralType = collateralType;
    }

    public String getValuationStatus() {
        return valuationStatus;
    }

    public void setValuationStatus(String valuationStatus) {
        this.valuationStatus = valuationStatus;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return "Collateral{" +
                "id=" + id +
                ", collateralType='" + collateralType + '\'' +
                ", valuationStatus='" + valuationStatus + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", createdDate=" + createdDate +
                '}';
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

}