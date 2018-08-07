package com.payclip.assessment.transactionapp.service;

import com.payclip.assessment.transactionapp.model.Transaction;
import com.payclip.assessment.transactionapp.repository.TransactionRepository;
import java.io.IOException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    
    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    @Autowired
    TransactionRepository tr;
    
    void addTtransaction(String transactionString, int userId) throws IOException {
        MAPPER.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Transaction transaction = MAPPER.readValue(transactionString, Transaction.class);
        transaction.generateUUID();
        transaction.setUserId(userId);
        System.out.println(tr.save(transaction));
    }
    
    void listTransactions(int userId) {
        System.out.println("[");
        tr.list(userId).forEach((item) -> {
            System.out.println(item);
        });
        System.out.println("]");
    }
    
    void sumTransactions(int userId) {
        System.out.println("{\"user_id\":" + userId + ",\"sum\":" + (float) tr.list(userId).stream().mapToDouble(item -> item.getAmount()).sum() + "}");
    }
    
    void showTransaction(int userId, String transactionId) throws IOException {
        Transaction transaction = tr.get(userId, transactionId);
        if(transaction == null)
            System.out.println("TRANSACTION NOT FOUND");
        else
            System.out.println(tr.get(userId, transactionId));
    }

    @Override
    public void processingTransaction(String arguments[]) throws IOException {
        if(arguments.length > 1) {
            if(arguments[0] != null && arguments[1] != null)
                if(arguments[1].equals("add")){
                    addTtransaction(arguments[2], Integer.parseInt(arguments[0]));
                }else if(arguments[1].equals("list")){
                    listTransactions(Integer.parseInt(arguments[0]));
                }else if(arguments[1].equals("sum")){
                    sumTransactions(Integer.parseInt(arguments[0]));
                }else if(arguments.length < 3){
                    showTransaction(Integer.parseInt(arguments[0]), arguments[1]);
                }
        } else {
            System.out.println("OPERATION NOT VALID");
        }
    }
    
}
