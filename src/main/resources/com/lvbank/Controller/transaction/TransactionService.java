package com.lvbank.Controller.transaction;

import com.lvbank.model.transaction.TransferTransaction;

import javax.servlet.http.HttpSession;

public class TransactionService {
    boolean doTransferTransaction(TransferTransaction transferTransaction,double accountNumber){
        boolean isTransferRegistered=false;

        TransactionDataLogic dataLogic = new TransactionDataLogic();

        if(dataLogic.checkTransaction(transferTransaction,accountNumber) && dataLogic.updateTransactionAmount(transferTransaction,accountNumber) && dataLogic.insertTransferRecord(transferTransaction,accountNumber)){
            isTransferRegistered=true;
        }

        return isTransferRegistered;
    }
}
