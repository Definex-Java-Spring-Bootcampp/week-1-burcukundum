package com.patika.kredinbizdenservice.model;

import java.math.BigDecimal;

public class LoanInfo {
        private String userName;
        private BigDecimal loanAmount;

        public LoanInfo(String userName, BigDecimal loanAmount) {
            this.userName = userName;
            this.loanAmount = loanAmount;
        }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
