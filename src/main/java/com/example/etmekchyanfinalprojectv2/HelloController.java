package com.example.etmekchyanfinalprojectv2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloController {
    @FXML
    private Label welcomeText;

    class TestRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 4; i++) {
                welcomeText.setText(Thread.currentThread().getName() + ": " + i);
            }
        }

        @FXML
        protected void onHelloButtonClick() {
            welcomeText.setText("Welcome to JavaFX Application!");
        }

        @FXML
        protected void onTestingThreads() {
            welcomeText.setText("Lets try to watch, how java works with threads." +
                    " Threads help us to optimize our program in case when we need to get result from operation/s faster");
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Runnable r = new TestRunnable();
            Thread t1 = new Thread(r);
            Thread t2 = new Thread(r);
            Thread t3 = new Thread(r);

            t1.start();
            t2.start();
            t3.start();
        }
        @FXML
        protected void onTestLogging() {
            Logger logger = Logger.getLogger("MyCustomLogger");
            Handler handler;
            try {
                handler = new FileHandler("test.log");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            logger.addHandler(handler);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            logger.log(Level.INFO, "Hello from new Logging event!. Current time : " + now);
        }
    }


}