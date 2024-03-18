package com.lvbank.model.transaction.Card;

import java.time.LocalDateTime;

public class CoBrandedCreditCard extends CreditCard{
    private String merchantName;
    private double merchantOfferPercentage;

    public CoBrandedCreditCard(String cardName, LocalDateTime inceptionDate, boolean isActive, String paymentGateway, int interestFreeCreditDays, double rateOfInterest, String merchantName, double merchantOfferPercentage) {
        super(cardName, inceptionDate, isActive, paymentGateway, interestFreeCreditDays, rateOfInterest);
        this.merchantName = merchantName;
        this.merchantOfferPercentage = merchantOfferPercentage;
    }
    public CoBrandedCreditCard(double cardNumber,LocalDateTime validFromDate,LocalDateTime expiryDate,String paymentGateway,int interestFreeCreditDays,double rateOfInterest,String merchantName,double merchantOfferPercentage){
        super(cardNumber,validFromDate,expiryDate,paymentGateway,interestFreeCreditDays,rateOfInterest);
        this.merchantName=merchantName;
        this.merchantOfferPercentage=merchantOfferPercentage;
    }
    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public double getMerchantOfferPercentage() {
        return merchantOfferPercentage;
    }

    public void setMerchantOfferPercentage(double merchantOfferPercentage) {
        this.merchantOfferPercentage = merchantOfferPercentage;
    }
}
