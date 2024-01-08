package com.example.project.SpringBoot.FinalProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.SpringBoot.FinalProject.Entity.Employee;
import com.example.project.SpringBoot.FinalProject.Repositary.EmpRepositary;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepositary repo;
	
	public void AddEmp (Employee e)
	{
		repo.save(e);
	}
	
	public List<Employee>getAllEmp(){
		return repo.findAll();
	}
	
	public Employee getEmpById(int id) {
		Optional<Employee> e=repo.findById(id);
		if(e.isPresent()) {
			return e.get();
			
		}
		return null;
	}
	
	public void deleteEmp(int id) {
		repo.deleteById(id);
	}

}
