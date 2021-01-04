package io.dorbae.tdd.ch03;

import java.time.LocalDate;

/*
 *****************************************************************
 *
 * PayDate
 *
 * @description PayDate
 *
 *
 *****************************************************************
 *
 * @version 1.0.0    2021/01/05 1:33     dorbae	최초 생성
 * @since 2021/01/05 1:33
 * @author dorbae(dorbae.io @ gmail.com)
 *
 */
public class PayData {

    private LocalDate billingDate;
    private int payAmount;

    private PayData() {
    }

    public PayData(LocalDate billingDate, int payAmount) {
        this.billingDate = billingDate;
        this.payAmount = payAmount;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(LocalDate billingDate) {
        this.billingDate = billingDate;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private PayData data = new PayData();

        public Builder billingDate(LocalDate billingDate) {
            data.billingDate = billingDate;
            return this;
        }

        public Builder payAmount(int payAmount) {
            data.payAmount = payAmount;
            return this;
        }

        public PayData build() {
            return data;
        }
    }
}
