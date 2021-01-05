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
            LocalDate candidateExp = payData.getBillingDate().plusMonths(1L);
            if (payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {
                return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
            }
        }

        return payData.getBillingDate().plusMonths(1L);
    }
}
