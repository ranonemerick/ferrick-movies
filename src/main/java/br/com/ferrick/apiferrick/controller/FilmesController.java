package br.com.ferrick.apiferrick.controller;

import br.com.ferrick.apiferrick.domain.filme.DadosCadastroFilme;
import br.com.ferrick.apiferrick.domain.filme.Filme;
import br.com.ferrick.apiferrick.domain.filme.FilmeRepository;
import br.com.ferrick.apiferrick.domain.filme.DadosAtualizacaoFilme;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/filmes")
public class FilmesController {

    @Autowired
    private FilmeRepository repository;

    @GetMapping("/formulario")
    public String carregarFormulario(Long id, Model model) {
        if(id != null){
            var filme = repository.getReferenceById(id);
            model.addAttribute("filme", filme);
        }
        return "filmes/formulario";
    }

    @GetMapping
    public String carregarLista(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "filmes/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastrarFilmes(@ModelAttribute DadosCadastroFilme dados){
           var filme = new Filme(dados);
           repository.save(filme);
        return "redirect:/filmes";
    }

    @DeleteMapping
    @Transactional
    public String removerFilme(Long id) {
        repository.deleteById(id);
        return "redirect:/filmes";
    }
    @PutMapping
    @Transactional
    public String atualizarFilme(DadosAtualizacaoFilme dados) {
        var filme = repository.getReferenceById(dados.id());
        filme.atualizaDados(dados);

        return "redirect:/filmes";
    }
}
