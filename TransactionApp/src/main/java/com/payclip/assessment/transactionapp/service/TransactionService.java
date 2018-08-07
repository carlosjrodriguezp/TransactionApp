package com.payclip.assessment.transactionapp.service;

import java.io.IOException;

public interface TransactionService {
    
    public void processingTransaction(String arguments[]) throws IOException;
    
}
