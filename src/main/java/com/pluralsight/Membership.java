package com.pluralsight;

import java.math.BigDecimal;

public class Membership {
    private String memberName;
    private int months;
    private BigDecimal baseRate;

    public Membership(String memberName,
                      int months,
                      BigDecimal baseRate){
        this.memberName = memberName;
        this.months = months;
        this.baseRate = baseRate;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public BigDecimal getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(BigDecimal baseRate) {
        this.baseRate = baseRate;
    }

    public BigDecimal getMonthlyPrice(){
        return baseRate;
    }

    public BigDecimal getSignUpFee(){
        BigDecimal signUpFee = new BigDecimal("49.00");
        return signUpFee;
    }

    public BigDecimal getContractTotal(){
        BigDecimal total = getSignUpFee().add(getMonthlyPrice().multiply(new BigDecimal(getMonths())));
        return total;
    }

    public String toString() {
        String string = "Membership | " + getMemberName() + " | Months: " + getMonths();
        return super.toString();
    }
}
