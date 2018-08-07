package com.payclip.assessment.transactionapp.service;

import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public void processingTransaction(String arguments[]) {
        if(arguments.length > 1) {
            if(arguments[0] != null && arguments[1] != null)
                System.out.println("Args "+ arguments[0] + " / " + arguments[1]);
        } else {
            System.out.println("NO OPTION SELECTED");
        }
    }
    
}
