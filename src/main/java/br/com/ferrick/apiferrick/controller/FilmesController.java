package br.com.ferrick.apiferrick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/filmes")
public class FilmesController {

    @GetMapping
    public String carregarFormulario(){
        return "filmes/formulario";
    }

}
