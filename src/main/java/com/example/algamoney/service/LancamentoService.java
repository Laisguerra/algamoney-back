package com.example.algamoney.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.algamoney.model.Lancamento;
import com.example.algamoney.model.pessoa.Pessoa;
import com.example.algamoney.repository.LancamentoRepository;
import com.example.algamoney.repository.PessoaRepository;
import com.example.algamoney.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {
	//ATRIBUTOS
	@Autowired PessoaRepository pessoaRepository;
	
	@Autowired LancamentoRepository lancamentoRepository; 
	//MÉTODOS PÚBLICOS
	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
		if (pessoa == null || pessoa.isInativo()){
			throw new PessoaInexistenteOuInativaException();
		}
		return lancamentoRepository.save(lancamento);
	}
	
}
