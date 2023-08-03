package br.com.ferrick.apiferrick.controller;

import br.com.ferrick.apiferrick.domain.filme.DadosCadastroFilme;
import br.com.ferrick.apiferrick.domain.filme.Filme;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/filmes")
public class FilmesController {

    private List<Filme> filmes =new ArrayList<>();

    @GetMapping
    public String carregarFormulario(){
        return "filmes/formulario";
    }

    @PostMapping
    public String cadastrarFilmes(DadosCadastroFilme dados){
        var filme = new Filme(dados);
        filmes.add(filme);
        System.out.println(filmes);
        return "filmes/formulario";
    }



}
