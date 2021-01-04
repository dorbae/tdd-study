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
  @Test
  void meetAllCriteriaThenString() {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();
    PasswordStrength result = meter.meter("ab12!@AB");
    assertEquals(PasswordStrength.STRONG, result);

    PasswordStrength result2 = meter.meter("abc1!Add");
    assertEquals(PasswordStrength.STRONG, result2);
  }

  @Test
  void meetOtherCriteriaExceptForLengthThenNormal() {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();
    PasswordStrength result = meter.meter("ab12!@A");
    assertEquals(PasswordStrength.NORMAL, result);
  }
}
