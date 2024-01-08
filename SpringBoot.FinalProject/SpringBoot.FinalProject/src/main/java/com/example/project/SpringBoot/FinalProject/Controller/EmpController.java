package com.example.project.SpringBoot.FinalProject.Controller;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.project.SpringBoot.FinalProject.Entity.Employee;
import com.example.project.SpringBoot.FinalProject.Service.EmpService;

import jakarta.servlet.http.HttpSession;

	@Controller
	public class EmpController {
		
		@Autowired
		private EmpService Service;
		
		
		@GetMapping("/")
		public String home(Model m) {
			List<Employee> emp = Service.getAllEmp();
			m.addAttribute("emp" , emp);
			return "Index";
		}
		
		@GetMapping("/Add_emp")
		public String Add_emp() {
		return "Add_emp";
	}
		
		@PostMapping("/register")
		public String empregister(@ModelAttribute Employee em, HttpSession session) {
			System.out.println(em);
			Service.AddEmp(em);
			session.setAttribute("msg", "Employee Added Successfully");
			return "redirect:/";
		}
		@GetMapping("/edit/{id}")
		public String edit(@PathVariable int id, Model m) {
			Employee e=Service.getEmpById(id);
			m.addAttribute("emp" , e);
			return "edit";
			
		}
		
		@PostMapping("/update")
		public String updateEmp (@ModelAttribute Employee e , HttpSession session) {
			
			Service.AddEmp(e);
			session.setAttribute("msg", "employee updated Successfully");
			return "redirect:/";
			
		}
		
		@GetMapping("/delete/{id}")
		public String deleteEmp (@PathVariable int id, HttpSession session) {
			Service.deleteEmp(id);
			session.setAttribute("msg", "Employee Deleted succesfully");
			return "redirect:/";
		}

	}

