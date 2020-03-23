package com.training.nmusabirova.hw7;

public interface Validator<T> {
    void validate(T t) throws ValidationFailedException;
}
