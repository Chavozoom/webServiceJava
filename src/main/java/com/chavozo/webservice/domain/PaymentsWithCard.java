package com.chavozo.webservice.domain;

import javax.persistence.Entity;

import com.chavozo.webservice.domain.enums.PaymentState;

@Entity
public class PaymentsWithCard extends Payment {
    private static final long serialVersion = 1L;

    private Integer numberOfInstallments;

    public PaymentsWithCard() {
    }

    public PaymentsWithCard(Integer id, PaymentState paymentState,
            Order order, Integer numberOfInstallments) {
        super(id, paymentState, order);
        this.numberOfInstallments = numberOfInstallments;
    }

    public Integer getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }
}
