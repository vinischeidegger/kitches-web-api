package es.kitches.webapp;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
public class KitchesApiWebApp {

    public static void main(String[] args) throws Exception {
    	SpringApplication.run(KitchesApiWebApp.class, args);
    }
    
}