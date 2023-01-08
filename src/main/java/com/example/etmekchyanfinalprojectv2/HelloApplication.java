package com.example.etmekchyanfinalprojectv2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HelloApplication extends Application {
    private String GetPropValue(String key)
    {
        InputStream inputStream =getClass().getClassLoader().getResourceAsStream("C:\\Users\\User\\EtmekchyanFinalProjectV2\\src\\main\\resources\\myTestProperties.properties");
        Properties prop = new Properties();
        try {
            prop.load(inputStream);
            return prop.getProperty(key);

        } catch (IOException e) {
            throw new RuntimeException("Could not get property with key:  " + key);
        }
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello, my name is " + GetPropValue("MyName")
                + "and today we use language " + GetPropValue("WhichLanguageILove")
                + ", but im " + GetPropValue("AmIGoodAtJava") + "good at this Language" +
                ".Here I used properties, now im gonna to use different threads to  ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}