package com.test.example.practice.exception;

import lombok.Data;


public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(String hint) {
        super(hint);
    }

}
