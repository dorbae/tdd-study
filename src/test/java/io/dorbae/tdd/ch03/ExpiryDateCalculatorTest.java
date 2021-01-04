package io.dorbae.tdd.ch03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

/*
 *****************************************************************
 *
 * ExpiryDateCalculatorTest
 *
 * @description ExpiryDateCalculatorTest
 *
 *
 *****************************************************************
 *
 * @version 1.0.0    2021/01/05 0:56     dorbae	최초 생성
 * @since 2021/01/05 0:56
 * @author dorbae(dorbae.io @ gmail.com)
 *
 */
public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부하면_한달_뒤가_만료일_됨() {
        this.assertExpiryDate(LocalDate.of(2020, 3, 1), 10_000, LocalDate.of(2020, 4, 1));
        this.assertExpiryDate(LocalDate.of(2020, 5, 5), 10_000, LocalDate.of(2020, 6, 5));
        this.assertExpiryDate(LocalDate.of(2020, 1, 31), 10_000, LocalDate.of(2020, 2, 29));
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음() {
        this.assertExpiryDate(LocalDate.of(2020, 1, 31), 10_000, LocalDate.of(2020, 2, 28));
    }

    private void assertExpiryDate(LocalDate billingDate, int payAmount,
        LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.calculateExpiryDate(billingDate, payAmount);
        assertEquals(expectedExpiryDate, realExpiryDate);
    }
}
