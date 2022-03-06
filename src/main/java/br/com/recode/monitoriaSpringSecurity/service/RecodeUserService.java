package br.com.recode.monitoriaSpringSecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.recode.monitoriaSpringSecurity.repository.RecodeUserRepository;

@Service
public class RecodeUserService implements UserDetailsService{

	@Autowired
	private RecodeUserRepository recodeUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(recodeUserRepository.findByUsername(username))
				.orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado"));
	}

}
