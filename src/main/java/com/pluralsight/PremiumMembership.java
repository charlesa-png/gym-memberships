package com.pluralsight;

import java.math.BigDecimal;

public class PremiumMembership extends Membership {
    private int guestPasses;

    public PremiumMembership(String memberName,
                             int months,
                             BigDecimal baseRate,
                             int guestPasses) {
        super(memberName, months, baseRate);
        this.guestPasses = guestPasses;
    }

    public int getGuestPasses() {
        return guestPasses;
    }

    public void setGuestPasses(int guestPasses) {
        this.guestPasses = guestPasses;
    }

    @Override
    public BigDecimal getMonthlyPrice() {
        return getBaseRate().add(new BigDecimal("18.50"));
    }

    public void useGuestPass(){
        if (guestPasses >= 1){
            this.guestPasses = guestPasses - 1;
            System.out.println(getMemberName() + " used a guest pass. Passes left: " + getGuestPasses() + "\n");
        }else{
            System.out.println(getMemberName() + " has no guest passes left.\n");
        }
    }

    @Override
    public BigDecimal getSignUpFee() {
        if (getMonths() >= 12){
            return new BigDecimal("0.00");
        }
        return super.getSignUpFee();
    }

    @Override
    public String toString() {
        String string = "Premium | " + getMemberName() + " | Months: " + getMonths() + " | Guest passes: " + getGuestPasses();
        return string;
    }
}
