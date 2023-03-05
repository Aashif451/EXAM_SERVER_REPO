package com.gof.examportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gof.examportal.Models.Roles;



public interface RoleRepository extends JpaRepository<Roles, Long>{

}
