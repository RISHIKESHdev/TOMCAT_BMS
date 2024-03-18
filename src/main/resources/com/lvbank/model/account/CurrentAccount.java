package com.lvbank.model.account;

import java.time.LocalDateTime;

public class CurrentAccount extends Account{
    private double overDraftLimit;

    public CurrentAccount(double currentBalance, double availableBalance, double creditScore, LocalDateTime accountInceptionDate, double overDraftLimit) {
        super(currentBalance, availableBalance, creditScore, accountInceptionDate);
        this.overDraftLimit = overDraftLimit;
    }

    public double getOverDraftLimit() {
        return overDraftLimit;
    }

    public void setOverDraftLimit(double overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }
}