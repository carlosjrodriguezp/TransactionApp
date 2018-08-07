package com.payclip.assessment.transactionapp.repository;

import com.payclip.assessment.transactionapp.model.Transaction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {
    
    private static final String FILE_NAME = "data-stored";
    private static final ObjectMapper MAPPER = new ObjectMapper();

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
        try {
            List<Transaction> list = readFile();   
            return list.stream().filter(item -> { 
                return item.getUserId() == userId;
            }).collect(Collectors.toList());

        } catch (IOException ex) {
            Logger.getLogger(TransactionRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Transaction get(int userId, String transactionId) throws IOException {
            List<Transaction> list = readFile();   
            return list.stream().filter(item -> { 
                return (item.getId().equals(transactionId) && item.getUserId() == userId);
            }).collect(Collectors.toList()).get(0);
    }
    
    private List<Transaction> readFile() throws FileNotFoundException, IOException {
        MAPPER.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        List<Transaction> list = new LinkedList<>();
        String line = null;
        FileReader fr = new FileReader(FILE_NAME);
        BufferedReader br = new BufferedReader(fr);
        while((line = br.readLine()) != null) {
            list.add(MAPPER.readValue(line, Transaction.class));
        }
        return list;
    }
    
}
