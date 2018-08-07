package com.payclip.assessment.transactionapp.repository;

import com.payclip.assessment.transactionapp.model.Transaction;
import java.util.List;

public interface TransactionRepository {
    Transaction save(Transaction transaction);
    List<Transaction> list(int userId);
    Transaction get(String transactionId);
}
