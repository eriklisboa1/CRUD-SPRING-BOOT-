package br.com.lisboa.crud.repository;

import br.com.lisboa.crud.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository  extends JpaRepository<Pessoa, String> {

    List<Pessoa> findByNome(String nome); //fazer busca por nome da pessoa la no busca do controller
}
