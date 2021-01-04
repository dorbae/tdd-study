package io.dorbae.tdd.ch02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 *****************************************************************
 *
 * CalculatorTest
 *
 * @description CalculatorTest
 *
 *
 *****************************************************************
 *
 * @version 1.0.0    2021/01/04 22:42     dorbae	최초 생성
 * @since 2021/01/04 22:42
 * @author dorbae(dorbae.io @ gmail.com)
 *
 */
public class CalculatorTest {
  @Test
  void plus() {
    int result = Calculator.plus(1, 2);
    assertEquals(3, result);
    assertEquals(5, Calculator.plus(4, 1));
  }

}
