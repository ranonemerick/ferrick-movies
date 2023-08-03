package br.com.ferrick.apiferrick.controller;

import br.com.ferrick.apiferrick.domain.filme.DadosCadastroFilme;
import br.com.ferrick.apiferrick.domain.filme.Filme;
import br.com.ferrick.apiferrick.domain.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/filmes")
public class FilmesController {

    @Autowired
    private FilmeRepository repository;

    @GetMapping("/formulario")
    public String carregarFormulario() {
        return "filmes/formulario";
    }

    @GetMapping()
    public String carregarLista(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "filmes/listagem";
    }

    @PostMapping
    public String cadastrarFilmes(DadosCadastroFilme dados) {
        var filme = new Filme(dados);
        repository.save(filme);
        return "redirect:/filmes";
    }


}
