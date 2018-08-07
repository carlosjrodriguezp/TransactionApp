package com.payclip.assessment.transactionapp;

import com.payclip.assessment.transactionapp.service.TransactionService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.payclip.assessment.transactionapp")
public class MainApp {
    
    @Autowired
    TransactionService ts;

    public static void main(String[] args) throws IOException {        
        ApplicationContext acac = new AnnotationConfigApplicationContext(MainApp.class);
        MainApp app = acac.getBean(MainApp.class);
        app.init(args);
    }
    
    private void init(String arguments[]) throws IOException{
        ts.processingTransaction(arguments);
    }
    
}
