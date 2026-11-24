package com.pluralsight;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    public static void printCosts(Membership membership){
        System.out.println("\n\tMonthly Price: " + membership.getMonthlyPrice() + ", sign-up fee: " + membership.getSignUpFee() + ", contract total: $" + membership.getContractTotal() + "\n");
    }
    public static void main(String[] args) {
        ArrayList<Membership> memberships = new ArrayList<>();
        BigDecimal monthlyIncome = new BigDecimal("0.00");
        BigDecimal allContracts = new BigDecimal("0.00");

        System.out.println("=== Gym Memberships ===");

        // 'Membership' is abstract; cannot be instantiated
        //Membership regularMembership = new Membership("Henry Clark", 3, new BigDecimal("30.00"));
        //memberships.add(regularMembership);



//        System.out.println(titleLine + "\n\n" + regularMembership);
        BasicMembership aBasicMembership = new BasicMembership("Alice Johnson", 6, new BigDecimal("30.00"), true);
        BasicMembership bBasicMembership = new BasicMembership("Bob Smith", 2, new BigDecimal("27.50"), false);
        memberships.add(aBasicMembership);
        memberships.add(bBasicMembership);
//        System.out.println("\n" + aBasicMembership);
//        System.out.println("\n" + bBasicMembership);
        PremiumMembership cPremiumMembership = new PremiumMembership("Carol White", 12, new BigDecimal("30.00"), 2);
        PremiumMembership fPremiumMembership = new PremiumMembership("Frank Miller", 3, new BigDecimal("30.00"), 0);
        memberships.add(cPremiumMembership);
        memberships.add(fPremiumMembership);
//        System.out.println("\n" + cPremiumMembership);
//        System.out.println("\n" + fPremiumMembership);
        FamilyMembership gFamilyMembership = new FamilyMembership("Grace Lee", 12, new BigDecimal("30.00"), 3);
        FamilyMembership eFamilyMembership = new FamilyMembership("Emma Wilson", 6, new BigDecimal("30.00"), 1);
        memberships.add(gFamilyMembership);
        memberships.add(eFamilyMembership);
//        System.out.println("\n" + gFamilyMembership);
//        System.out.println("\n" + eFamilyMembership);

        for (Membership membership : memberships) {
            System.out.println(membership);
            printCosts(membership);
            monthlyIncome = monthlyIncome.add(membership.getMonthlyPrice());
            allContracts = allContracts.add(membership.getContractTotal());
        }

        System.out.println("\n--- Totals ---\n");
        System.out.println("Memberships: " + memberships.size());
        System.out.println("\nMonthly income: $" + monthlyIncome);
        System.out.println("\nAll contracts: $" + allContracts + "\n");

        System.out.println("\n--- Front desk notes ---\n");

        for (Membership membership : memberships) {
            if (membership instanceof BasicMembership){
                if(((BasicMembership) membership).isOffPeakOnly()){
                    System.out.println(membership.getMemberName() + ": entry between 10:00 and 16:00 only\n");
                }
            }
        }

        cPremiumMembership.useGuestPass();
        fPremiumMembership.useGuestPass();

        int ePlusOne = eFamilyMembership.getExtraMembers() + 1;
        int gPlusOne = gFamilyMembership.getExtraMembers() + 1;

        System.out.println(gFamilyMembership.getMemberName() + ": print " + gPlusOne + " key cards\n");
        System.out.println(eFamilyMembership.getMemberName() + ": print " + ePlusOne + " key cards\n");

        System.out.println("\n--- Kinds ---\n");
        for (Membership membership : memberships) {
            System.out.println(membership.getMemberName() + ": " + membership.getClass().getSimpleName() + "\n");
        }
        }

    }

