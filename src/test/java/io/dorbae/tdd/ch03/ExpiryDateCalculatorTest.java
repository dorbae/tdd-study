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
        this.assertExpiryDate(
            PayData.builder().billingDate(LocalDate.of(2020, 3, 1)).payAmount(10_000).build(),
            LocalDate.of(2020, 4, 1));
        this.assertExpiryDate(
            PayData.builder().billingDate(LocalDate.of(2020, 5, 5)).payAmount(10_000).build(),
            LocalDate.of(2020, 6, 5));
        this.assertExpiryDate(
            PayData.builder().billingDate(LocalDate.of(2020, 1, 31)).payAmount(10_000).build(),
            LocalDate.of(2020, 2, 29));
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음() {
        this.assertExpiryDate(
            PayData.builder().billingDate(LocalDate.of(2019, 1, 31)).payAmount(10_000).build(),
            LocalDate.of(2019, 2, 28));
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_만원_납부() {
        PayData payData = PayData.builder().firstBillingDate(LocalDate.of(2020, 1, 30))
            .billingDate(LocalDate.of(2020, 2, 29)).payAmount(10_000).build();

        this.assertExpiryDate(payData, LocalDate.of(2020, 3, 30));

        PayData payData3 = PayData.builder()
            .firstBillingDate(LocalDate.of(2020, 5, 31))
            .billingDate(LocalDate.of(2020, 6, 30))
            .payAmount(10_000)
            .build();

        this.assertExpiryDate(payData3, LocalDate.of(2020, 7, 31));
    }

    @Test
    void 이만원_이상_납부하면_비례해서_만료일_계산() {
        this.assertExpiryDate(PayData.builder()
            .billingDate(LocalDate.of(2020, 3, 1))
            .payAmount(20_000)
            .build(), LocalDate.of(2020, 5, 1));

        this.assertExpiryDate(PayData.builder()
            .billingDate(LocalDate.of(2020, 3, 1))
            .payAmount(30_000)
            .build(), LocalDate.of(2020, 6, 1));
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_이만원_이상_납부() {
        this.assertExpiryDate(PayData.builder()
            .firstBillingDate(LocalDate.of(2020, 1, 31))
            .billingDate(LocalDate.of(2020, 2, 29))
            .payAmount(20_000)
            .build(), LocalDate.of(2020, 4, 30));

        this.assertExpiryDate(PayData.builder()
            .firstBillingDate(LocalDate.of(2020, 1, 31))
            .billingDate(LocalDate.of(2020, 2, 29))
            .payAmount(40_000)
            .build(), LocalDate.of(2020, 6, 30));

        this.assertExpiryDate(PayData.builder()
            .firstBillingDate(LocalDate.of(2020, 3, 31))
            .billingDate(LocalDate.of(2020, 4, 30))
            .payAmount(30_000)
            .build(), LocalDate.of(2020, 7, 31));
    }

    @Test
    void 십만원을_납부하면_1년_제공() {
        this.assertExpiryDate(PayData.builder()
            .billingDate(LocalDate.of(2020, 1, 28))
            .payAmount(100_000)
            .build(), LocalDate.of(2021, 1, 28));
    }

    private void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.calculateExpiryDate(payData);
        assertEquals(expectedExpiryDate, realExpiryDate);
    }
}
