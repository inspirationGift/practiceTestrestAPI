package com.test.example.practice.model.enums;

import com.test.example.practice.model.Payment;

import java.util.List;

public enum PaymentStatus {
    PAID, PARTIALLY_PAID, NOT_PAID;

    public static PaymentStatus getStatus(List<Payment> payment, float amount) {

        Float total = payment.stream()
                .filter(pay -> pay.getAcceptanceStatus() == PaymentAcceptance.ACCEPTED)
                .map(Payment::getAmount)
                .reduce(0f, Float::sum);

        if (total == 0) return NOT_PAID;
        if (total < amount) return PARTIALLY_PAID;
        return PAID;
    }


}
