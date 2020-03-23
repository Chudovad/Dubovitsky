package com.training.nmusabirova.hw7;

public class IntegerValidator implements Validator {
    @Override
    public void validate(Object obj) throws ValidationFailedException {
        int number = Integer.parseInt(obj.toString());
        if ((number < 1) || (number >= 11)) {
            throw new ValidationFailedException();
        } else {
            System.out.print(number);
        }
    }
}