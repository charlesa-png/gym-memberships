package com.pluralsight;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        String titleLine = "=== Gym Memberships ===";
        Membership regularMembership = new Membership("Henry Clark", 3, new BigDecimal("30.00"));
        System.out.println(titleLine + "\n\n" + regularMembership);
        BasicMembership aBasicMembership = new BasicMembership("Alice Johnson", 6, new BigDecimal("30.00"), true);
        BasicMembership bBasicMembership = new BasicMembership("Bob Smith", 2, new BigDecimal("27.50"), false);
        System.out.println("\n" + aBasicMembership);
        System.out.println("\n" + bBasicMembership);
        PremiumMembership cPremiumMembership = new PremiumMembership("Carol White", 12, new BigDecimal("30.00"), 2);
        PremiumMembership fPremiumMembership = new PremiumMembership("Frank Miller", 3, new BigDecimal("30.00"), 0);
        System.out.println("\n" + cPremiumMembership);
        System.out.println("\n" + fPremiumMembership);
        FamilyMembership gFamilyMembership = new FamilyMembership("Grace Lee", 12, new BigDecimal("30.00"), 3);
        FamilyMembership eFamilyMembership = new FamilyMembership("Emma Wilson", 6, new BigDecimal("30.00"), 1);
        System.out.println("\n" + gFamilyMembership);
        System.out.println("\n" + eFamilyMembership);

        System.out.println("\n--- Guest passes ---\n");
        cPremiumMembership.useGuestPass();
        cPremiumMembership.useGuestPass();
        cPremiumMembership.useGuestPass();
        fPremiumMembership.useGuestPass();

        System.out.println("\n--- Sign-up fee and contract total ---\n");
        System.out.println(regularMembership.getMemberName() + ": fee $" + regularMembership.getSignUpFee() + ", total $" + regularMembership.getContractTotal() + "\n");
        System.out.println(cPremiumMembership.getMemberName() + ": fee $" + cPremiumMembership.getSignUpFee() + ", total $" + cPremiumMembership.getContractTotal() + "\n");
        System.out.println(fPremiumMembership.getMemberName() + ": fee $" + fPremiumMembership.getSignUpFee() + ", total $" + fPremiumMembership.getContractTotal() + "\n");
        System.out.println(gFamilyMembership.getMemberName() + ": fee $" + gFamilyMembership.getSignUpFee() + ", total $" + gFamilyMembership.getContractTotal() + "\n");
        }
}
