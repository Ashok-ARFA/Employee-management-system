package com.example.project.SpringBoot.FinalProject.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.SpringBoot.FinalProject.Entity.Employee;

@Repository
public interface EmpRepositary extends JpaRepository<Employee, Integer>{

}
