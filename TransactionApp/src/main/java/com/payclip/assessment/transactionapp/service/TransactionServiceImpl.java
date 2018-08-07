package com.payclip.assessment.transactionapp.service;

import com.payclip.assessment.transactionapp.model.Transaction;
import com.payclip.assessment.transactionapp.repository.TransactionRepository;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    
    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    @Autowired
    TransactionRepository tr;
    
    Transaction addTtransaction(String transactionString) throws IOException {
        MAPPER.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Transaction transaction = MAPPER.readValue(transactionString, Transaction.class);
        transaction.generateUUID();
        return tr.save(transaction);
    }

    @Override
    public void processingTransaction(String arguments[]) {
        if(arguments.length > 1) {
            if(arguments[0] != null && arguments[1] != null)
                if(arguments[1].equals("add")){
                    System.out.println("ADD TRANSACTION: ./application <user_id> add <transaction_json>");
                try {
                    addTtransaction(arguments[2]);
                } catch (IOException ex) {
                    Logger.getLogger(TransactionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
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
