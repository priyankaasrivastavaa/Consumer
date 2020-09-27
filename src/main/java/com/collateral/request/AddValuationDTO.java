package com.collateral.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddValuationDTO implements Serializable {
    @JsonProperty("collateralId")
    private String collateralId;

    @JsonProperty("valuationStatus")
    private Status valuationStatus;

    public String getCollateralId() {
        return collateralId;
    }

    public AddValuationDTO setCollateralId(String collateralId) {
        this.collateralId = collateralId;
        return this;
    }

    @Override
    public String toString() {
        return "AddValuationDTO{" +
                "collateralId='" + collateralId + '\'' +
                ", valuationStatus=" + valuationStatus +
                '}';
    }

    public Status getValuationStatus() {
        return valuationStatus;
    }

    public AddValuationDTO setValuationStatus(Status valuationStatus) {
        this.valuationStatus = valuationStatus;
        return this;
    }
}
