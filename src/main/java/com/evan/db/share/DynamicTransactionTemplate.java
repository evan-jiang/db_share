package com.evan.db.share;

import org.springframework.transaction.support.TransactionTemplate;

public class DynamicTransactionTemplate{

    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }
    
    public TransactionTemplate resetTransactionTemplate(String productCode){
        ShareDBContainer.setDataSource(productCode);
        return transactionTemplate;
    }

}
