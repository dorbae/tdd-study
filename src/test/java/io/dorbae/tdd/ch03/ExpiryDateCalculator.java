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

    public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount) {
        return billingDate.plusMonths(1L);
    }

}
