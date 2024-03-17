package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.LoanType;

import java.math.BigDecimal;

import static com.patika.kredinbizdenservice.enums.LoanType.*;

public class LoanFactory {
    public static Loan createLoan(BigDecimal amount,Integer installment,Bank bank,Double interestRate, LoanType Type) {
        switch (Type) {
            case IHTIYAC_KREDISI:
                return new ConsumerLoan(amount,installment,interestRate);
            case KONUT_KREDISI:
                return new HouseLoan(amount,installment,interestRate);
            case ARAC_KREDISI:
                return new VechileLoan(amount,installment,interestRate);
            default:
                throw new IllegalArgumentException("Invalid loan type.");
        }
    }
}

