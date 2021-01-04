package io.dorbae.tdd.ch02;

/*
 *****************************************************************
 *
 * PasswordStrengthMeter
 *
 * @description PasswordStrengthMeter
 *
 *
 *****************************************************************
 *
 * @version 1.0.0    2021/01/04 22:56     dorbae	최초 생성
 * @since 2021/01/04 22:56
 * @author dorbae(dorbae.io @ gmail.com)
 *
 */
public class PasswordStrengthMeter {

    public PasswordStrength meter(String password) {
        if (password == null || password.isBlank()) {
            return PasswordStrength.INVALID;
        }

        int metCount = 0;
        boolean lengthEnough = password.length() >= 8;
        if (lengthEnough) {
            metCount++;
        }
        boolean containsNum = meetContainingNumberCriteria(password);
        if (containsNum) {
            metCount++;
        }
        boolean containsUpper = meetContainingUppercaseCriteria(password);
        if (containsUpper) {
            metCount++;
        }

        if (metCount == 1) {
            return PasswordStrength.WEAK;
        }

        if (!lengthEnough) {
            return PasswordStrength.NORMAL;
        }

        if (!containsNum) {
            return PasswordStrength.NORMAL;
        }

        if (!containsUpper) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }

    private boolean meetContainingNumberCriteria(String password) {
        for (char ch : password.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }

        return false;
    }

    private boolean meetContainingUppercaseCriteria(String password) {
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }

        return false;
    }
}
