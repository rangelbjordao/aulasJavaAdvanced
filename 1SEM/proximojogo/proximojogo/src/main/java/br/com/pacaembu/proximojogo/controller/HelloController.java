package br.com.pacaembu.proximojogo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/publico/hello")
    public String HelloPublico() {
        return "Endpoint publico - nao precisa login!";
    }

    @GetMapping("/seguro/hello")
    public String helloProtegido() {
        return "Endpoint protegido - voce esta autenticado!";
    }
}
