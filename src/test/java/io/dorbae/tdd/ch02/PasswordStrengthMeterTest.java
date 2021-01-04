package io.dorbae.tdd.ch02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 *****************************************************************
 *
 * PasswordStrengthMeterTest
 *
 * @description PasswordStrengthMeterTest
 *
 *
 *****************************************************************
 *
 * @version 1.0.0    2021/01/04 22:49     dorbae	최초 생성
 * @since 2021/01/04 22:49
 * @author dorbae(dorbae.io @ gmail.com)
 *
 */
public class PasswordStrengthMeterTest {
    /*
     * 비밀번호의 보안 강도 체크 (안전, 보통, 위험)
     */

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    @Test
    void meetAllCriteriaThenStrong() {
        this.assertStrength("ab12!@AB", PasswordStrength.STRONG);
        this.assertStrength("abc1!Add", PasswordStrength.STRONG);

    }

    @Test
    void meetOtherCriteriaExceptForLengthThenNormal() {
        this.assertStrength("ab12!@A", PasswordStrength.NORMAL);
    }

    @Test
    void meetOtherCriteriaExceptForNumberThenNormal() {
        this.assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }

    @Test
    void nullInputThenInvalid() {
        this.assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    void emptyInputThenInvalid() {
        this.assertStrength("", PasswordStrength.INVALID);
    }

    @Test
    void meetOtherCriteriaExceptForUppercaseThenNormal() {
        this.assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    @Test
    void meetOnlyLengthCriteriaThenWeak() {
        this.assertStrength("abdefghi", PasswordStrength.WEAK);
    }

    @Test
    void meetOnlyNumCriteriaThenWeak() {
        this.assertStrength("12345", PasswordStrength.WEAK);
    }

    @Test
    void meetOnlyUpperCriteriaThenWeak() {
        this.assertStrength("ABZEF", PasswordStrength.WEAK);
    }

    @Test
    void meetNoCriteriaThenWeak() {
        this.assertStrength("abc", PasswordStrength.WEAK);
    }

    private void assertStrength(String password, PasswordStrength expected) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expected, result);
    }
}
