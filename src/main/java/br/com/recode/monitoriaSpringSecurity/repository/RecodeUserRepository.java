package br.com.recode.monitoriaSpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.recode.monitoriaSpringSecurity.model.RecodeUser;

@Repository
public interface RecodeUserRepository extends JpaRepository<RecodeUser, Long>{
	
	RecodeUser findByUsername(String username);
	
}
