package br.com.lisboa.crud.controller;

import br.com.lisboa.crud.model.Pessoa;
import br.com.lisboa.crud.repository.PessoaRepository;
import jakarta.servlet.ServletOutputStream;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("pessoas")
public class PessoaController {
    private PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @PostMapping
    public Pessoa salvar(@RequestBody Pessoa pessoa) {
        System.out.println("Salvando pessoa " + pessoa.getNome());
        System.out.println(pessoa);


        var id = UUID.randomUUID().toString();
        pessoa.setId(id);

        pessoaRepository.save(pessoa);
        return pessoa;
    }
    @GetMapping("{id}")
    public Pessoa obterPessoaPorId(@PathVariable("id") String id) {
        return pessoaRepository.findById(id).orElse(null);
    }
    @DeleteMapping("{id}")
    public void deletarPessoa(@PathVariable("id") String id) {
        pessoaRepository.deleteById(id);
    }
    @PutMapping("{id}")
    public void atualizarPessoa(@PathVariable("id") String id,
                                @RequestBody Pessoa pessoa) {
        pessoa.setId(id);
        pessoaRepository.save(pessoa);
    }

    @GetMapping
    public List<Pessoa> listarPessoas(@RequestParam("nome") String nome) {
        return pessoaRepository.findByNome(nome);
    }



}
