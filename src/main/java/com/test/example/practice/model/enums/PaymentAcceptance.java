package com.test.example.practice.model.enums;

public enum PaymentAcceptance {
    PROCESSING(1), ACCEPTED(2), REJECTED(3), NON(0);

    int status;

    PaymentAcceptance(int status) {
        this.status = status;
    }

    public static PaymentAcceptance getStatus(int status) {
        switch (status) {
            case 1 -> {
                return PROCESSING;
            }
            case 2 -> {
                return ACCEPTED;
            }
            case 3 -> {
                return REJECTED;
            }
            default -> {
                return NON;
            }
        }
    }
}
