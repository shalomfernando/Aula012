package br.com.usjt.ccp3anmcahellospringboot.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.usjt.ccp3anmcahellospringboot.model.Aluno;
import br.com.usjt.ccp3anmcahellospringboot.repository.AlunosRepository;

@Controller
public class AlunosController {
	@Autowired
	private AlunosRepository alunosRepo;

	@GetMapping("/alunos")
	public ModelAndView listarAlunos() {
		
		ModelAndView mv = new ModelAndView("lista_alunos");
		List<Aluno> alunos = alunosRepo.findAll();
		mv.addObject("alunos", alunos);
		

	mv.addObject(new Aluno());
		
		return mv;
	}

	@PostMapping
	public String salvar(Aluno aluno) {
		alunosRepo.save(aluno);
		return "redirect:/alunos";
	}

}
