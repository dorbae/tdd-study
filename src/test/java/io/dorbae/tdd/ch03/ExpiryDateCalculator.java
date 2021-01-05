package io.dorbae.tdd.ch03;

import java.time.LocalDate;
import java.time.YearMonth;

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
        int addedMonth = payData.getPayAmount() / 10_000;
        if (payData.getFirstBillingDate() != null) {
            LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonth);
            final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
            if (dayOfFirstBilling != candidateExp.getDayOfMonth()) {
                final int dayLenOfCandiMon = YearMonth.from(candidateExp).lengthOfMonth();
                if (dayLenOfCandiMon < dayOfFirstBilling) {
                    return candidateExp.withDayOfMonth(dayLenOfCandiMon);
                }

                return candidateExp.withDayOfMonth(dayOfFirstBilling);
            }
        }

        return payData.getBillingDate().plusMonths(addedMonth);
    }
}
