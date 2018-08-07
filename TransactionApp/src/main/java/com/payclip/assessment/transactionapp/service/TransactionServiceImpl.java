package com.payclip.assessment.transactionapp.service;

import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public void processingTransaction(String arguments[]) {
        if(arguments.length > 1) {
            if(arguments[0] != null && arguments[1] != null)
                if(arguments[1].equals("add")){
                    System.out.println("ADD TRANSACTION: ./application <user_id> add <transaction_json>");
                }else if(arguments[1].equals("list")){
                    System.out.println("LIST TRANSACTIONS: ./application <user_id> list");
                }else if(arguments[1].equals("sum")){
                    System.out.println("SUM TRANSACTIONS: ./application <user_id> sum");
                }else if(arguments.length < 3){
                    System.out.println("SHOW TRANSACTION: ./application <user_id> <transaction_id>");
                }
        } else {
            System.out.println("NO OPTION SELECTED");
        }
    }
    
}
