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
        LocalDate billingDate = LocalDate.of(2020, 3, 1);
        int payAmount = 10_000;

        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);

        assertEquals(LocalDate.of(2020, 4, 1), expiryDate);


        LocalDate billingDate2 = LocalDate.of(2020, 5, 5);
        int payAmount2 = 10_000;

        ExpiryDateCalculator cal2 = new ExpiryDateCalculator();
        LocalDate expiryDate2 = cal2.calculateExpiryDate(billingDate2, payAmount2);

        assertEquals(LocalDate.of(2020, 6, 5), expiryDate2);
    }

}
