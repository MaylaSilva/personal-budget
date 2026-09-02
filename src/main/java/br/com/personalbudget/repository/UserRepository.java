package br.com.personalbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.personalbudget.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{

}
