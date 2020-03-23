package com.training.nmusabirova.hw7;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator implements Validator {

    @Override
    public void validate(Object obj) throws ValidationFailedException {
        String str = (String) obj;

        Pattern pattern = Pattern.compile("(^[A-Z])");
        Matcher matcher = pattern.matcher(str);

        if (!checkForNull(str)) {
            if (matcher.find()) {
                System.out.print(str);
            } else {
                throw new ValidationFailedException();
            }
        } else {
            throw new ValidationFailedException();
        }
    }

    private boolean checkForNull(String string) {
        boolean result = string.equals("");
        return result;
    }
}