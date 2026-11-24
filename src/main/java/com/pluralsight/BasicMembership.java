package com.pluralsight;

import java.math.BigDecimal;

public class BasicMembership extends Membership{
    private boolean offPeakOnly;

    public BasicMembership(String memberName, int months, BigDecimal baseRate, boolean offPeakOnly) {
        super(memberName, months, baseRate);
        this.offPeakOnly = offPeakOnly;
    }



    public boolean isOffPeakOnly() {
        return offPeakOnly;
    }

    public void setOffPeakOnly(boolean offPeakOnly) {
        this.offPeakOnly = offPeakOnly;
    }

    @Override
    public BigDecimal getMonthlyPrice() {
        if(isOffPeakOnly()) {
            return super.getMonthlyPrice().subtract(new BigDecimal("5.00"));
        }
        return super.getMonthlyPrice();
    }

    @Override
    public String toString() {
        String string = "Basic | " + getMemberName() + " | Months: " + getMonths() + " | Off-peak only: " + isOffPeakOnly();
        return string;
    }
}
