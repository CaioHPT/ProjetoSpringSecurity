package br.com.recode.monitoriaSpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.recode.monitoriaSpringSecurity.model.Pessoa;
import br.com.recode.monitoriaSpringSecurity.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public List<Pessoa> getAll(){
		return pessoaRepository.findAll();
	}
	
	public Pessoa getById(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if(pessoa.isPresent()) {
			return pessoa.get();
		}else {
			return null;
		}
	}
	
	public void save(Pessoa pessoa) {
		try {
			pessoaRepository.save(pessoa);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void update(Pessoa pessoa) {
		try {
			pessoaRepository.save(pessoa);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void deleteById(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if(pessoa.isPresent()) {
			pessoaRepository.delete(pessoa.get());
		}
	}
	
	public void delete(Pessoa pessoa) {
		try {
			pessoaRepository.delete(pessoa);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
