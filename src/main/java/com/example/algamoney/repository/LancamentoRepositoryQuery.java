package com.example.algamoney.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.algamoney.model.Lancamento;
import com.example.algamoney.repository.filter.LancamentoFilter;
import com.example.algamoney.repository.projection.ResumoLancamento;

public interface LancamentoRepositoryQuery {
	public Page<Lancamento> filtrar(LancamentoFilter lancamentofilter, Pageable pageable); 
	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentofilter, Pageable pageable);
}
