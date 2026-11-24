package com.pluralsight;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FamilyMembership extends Membership {
    private int extraMembers;

    public FamilyMembership(String memberName, int months, BigDecimal baseRate, int extraMembers) {
        super(memberName, months, baseRate);
        this.extraMembers = extraMembers;
    }

    public int getExtraMembers() {
        return extraMembers;
    }

    public void setExtraMembers(int extraMembers) {
        this.extraMembers = extraMembers;
    }

    @Override
    public BigDecimal getMonthlyPrice() {
       BigDecimal regularPrice = getBaseRate().add(new BigDecimal("12.50").multiply(new BigDecimal(getExtraMembers())));
        if (new BigDecimal(getExtraMembers()).compareTo(new BigDecimal("3"))>=0){
            BigDecimal newPrice;
            BigDecimal discount = regularPrice.divide(new BigDecimal("100")).multiply(new BigDecimal("10"));
            newPrice = regularPrice.subtract(discount);
            return newPrice.setScale(2, RoundingMode.HALF_UP);
        }
        return regularPrice;
    }

    @Override
    public String toString() {
        String string = "Family | " + getMemberName() + " | Months: " + getMonths() + " | Extra members: " + getExtraMembers();
        return string;
    }
}
