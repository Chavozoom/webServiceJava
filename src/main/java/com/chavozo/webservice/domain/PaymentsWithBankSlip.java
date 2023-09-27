package com.chavozo.webservice.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.chavozo.webservice.domain.enums.PaymentState;

@Entity
public class PaymentsWithBankSlip extends Payment {
    private static final long serialVersion = 1L;

    private Date dueDate;
    private Date paymentDate;

    public PaymentsWithBankSlip() {
    }

    public PaymentsWithBankSlip(Integer id, PaymentState paymentState,
            Order order, Date dueDate, Date paymentDate) {
        super(id, paymentState, order);
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
