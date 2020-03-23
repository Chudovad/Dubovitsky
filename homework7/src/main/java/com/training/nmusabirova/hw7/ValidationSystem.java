package com.training.nmusabirova.hw7;

public class ValidationSystem {
    public static void validate(Object obj) throws ValidationFailedException {
        Validator validator;
        if (obj instanceof String) {
            validator = new StringValidator();
            validator.validate(obj);
        } else if (obj instanceof Integer) {
            validator = new IntegerValidator();
            validator.validate(obj);
        } else {
            throw new ValidationFailedException();
        }
    }
}
