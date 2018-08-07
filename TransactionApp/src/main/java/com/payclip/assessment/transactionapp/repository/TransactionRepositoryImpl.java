package com.payclip.assessment.transactionapp.repository;

import com.payclip.assessment.transactionapp.model.Transaction;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {
    
    private static final String FILE_NAME = "data-stored";

    @Override
    public Transaction save(Transaction transaction) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(transaction.toString());
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(TransactionRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
