package com.pluralsight;

import java.math.BigDecimal;
import java.math.BigInteger;

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
            BigDecimal newPrice = new BigDecimal("0");
            newPrice = newPrice.subtract(regularPrice.divide(new BigDecimal("100").multiply(new BigDecimal("10"))));
            return newPrice;
        }
        return regularPrice;
    }
}
