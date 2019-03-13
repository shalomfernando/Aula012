package br.com.usjt.ccp3anmcahellospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.usjt.ccp3anmcahellospringboot.model.Aluno;

public interface AlunosRepository extends JpaRepository<Aluno, Long> {
	
}
