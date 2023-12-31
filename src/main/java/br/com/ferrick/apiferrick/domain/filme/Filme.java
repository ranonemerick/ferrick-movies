package br.com.ferrick.apiferrick.domain.filme;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Table(name = "filmes")
@Entity
@NoArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer duracao;
    private Integer lancamento;
    private String genero;

    public Filme(DadosCadastroFilme dados) {
        this.nome = dados.nome();
        this.duracao = dados.duracao();
        this.lancamento = dados.lancamento();
        this.genero = dados.genero();
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public Integer getLancamento() {
        return lancamento;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nome='" + nome +
                ", duracao=" + duracao +
                ", lancamento=" + lancamento +
                ", genero=" + genero +
                '}';
    }

    public void atualizaDados(DadosAtualizacaoFilme dados) {
        this.nome = dados.nome();
        this.duracao = dados.duracao();
        this.lancamento = dados.lancamento();
        this.genero = dados.genero();
    }
}
