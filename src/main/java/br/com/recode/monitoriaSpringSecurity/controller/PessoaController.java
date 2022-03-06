package br.com.recode.monitoriaSpringSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.recode.monitoriaSpringSecurity.model.Pessoa;
import br.com.recode.monitoriaSpringSecurity.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoa")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> getAll(@AuthenticationPrincipal UserDetails userDetails){
		System.out.println(userDetails);
		return ResponseEntity.ok().body(pessoaService.getAll());
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> getById(@PathVariable Long id){
		try {
			Pessoa pessoa = pessoaService.getById(id);
			return ResponseEntity.ok().body(pessoa);
		}catch (Exception ex) {
			// TODO: handle exception
			throw ex;
		}
	}
	
	@PostMapping(value = "/admin/add")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){
		try {
			pessoaService.save(pessoa);
			return ResponseEntity.ok().body(pessoa);
		}catch (Exception ex) {
			// TODO: handle exception
			throw ex;
		}
	}
	
	
	@PutMapping(value = "/admin/update")
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa){
		try {
			pessoaService.update(pessoa);
			return ResponseEntity.ok().body(pessoa);
		}catch (Exception ex) {
			// TODO: handle exception
			throw ex;
		}
	}
	
	@DeleteMapping(value = "/admin/{id}")
	public ResponseEntity<Pessoa> delete(@PathVariable Long id){
		try {
			Pessoa pessoa = pessoaService.getById(id);
			pessoaService.delete(pessoa);
			return ResponseEntity.ok().body(pessoa);
		}catch (Exception ex) {
			// TODO: handle exception
			throw ex;
		}
	}
	
}
