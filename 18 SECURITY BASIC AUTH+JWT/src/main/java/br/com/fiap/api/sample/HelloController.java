package br.com.fiap.api.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/publico/hello")
    public String helloPublico() {
        return "Endpoint público - não precisa de login!";
    }

    @GetMapping("/seguro/hello")
    public String helloProtegido() {
        return "Endpoint protegido - você está autenticado!";
    }
}