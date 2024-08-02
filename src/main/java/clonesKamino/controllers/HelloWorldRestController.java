package clonesKamino.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

    @GetMapping({"/hello", "hw", "hola"})
    public String helloWorld(){
        System.out.print("Solicitud ejecutada!");
        return "Hello, World!";
    }
}
