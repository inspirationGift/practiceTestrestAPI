package com.test.example.practice.exception;

import lombok.Data;


public class NullEntityReferenceException extends Exception {

    public NullEntityReferenceException(String hint) {
        super(hint);
    }

}
