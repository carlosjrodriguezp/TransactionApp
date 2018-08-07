package com.payclip.assessment.transactionapp.repository;

import com.payclip.assessment.transactionapp.model.Transaction;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    @Override
    public Transaction save(Transaction transaction) {
        System.out.println("TRANSACTION: " + transaction.toString());
        return transaction;
    }

    @Override
    public List<Transaction> list(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transaction get(String transactionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
