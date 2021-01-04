package io.dorbae.tdd.ch02;

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
    타입? result = meter.meter("ab12!@AB");
    assertEqaul(expected, result);
  }
}
