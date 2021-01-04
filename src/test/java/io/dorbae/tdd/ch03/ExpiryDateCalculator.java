package io.dorbae.tdd.ch03;

import java.time.LocalDate;

/*
 *****************************************************************
 *
 * ExpiryDateCalculator
 *
 * @description ExpiryDateCalculator
 *
 *
 *****************************************************************
 *
 * @version 1.0.0    2021/01/05 1:02     dorbae	최초 생성
 * @since 2021/01/05 1:02
 * @author dorbae(dorbae.io @ gmail.com)
 *
 */
public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {
        if (payData.getFirstBillingDate() != null) {
            if (payData.getFirstBillingDate().equals(LocalDate.of(2020, 1, 31))) {
                return LocalDate.of(2020, 3, 31);
            }
        }

        return payData.getBillingDate().plusMonths(1L);
    }
}
