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
    if (password.length() < 8) {
      return PasswordStrength.NORMAL;
    }

    boolean containsNum = false;
    for (char ch : password.toCharArray()) {
      if (ch >= '0' && ch <= '9') {
        containsNum = true;
        break;
      }
    }
    if (!containsNum) {
      return PasswordStrength.NORMAL;
    }

    return PasswordStrength.STRONG;
  }

}
