package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Student;
import com.service.StudentService;
@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		return "redirect:/list-users";
	}

	@RequestMapping(value = "/list-users", method = RequestMethod.GET)
	public String showStudentList(ModelMap model) {
		model.addAttribute("studentObj", service.retrieveStudents());
		return "list-users";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String showAddStudentPage(ModelMap model) {
		model.addAttribute("studentObj", new Student());
		return "user";
	}
	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addStudent(ModelMap model, @Valid Student user, BindingResult result) throws Exception {
		if (result.hasErrors())
			return "user";
		service.addStudent(user);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-users";
	}
	@RequestMapping(value = "/delete-user", method = RequestMethod.GET)
	public String deleteStudent(@RequestParam int id) throws Exception {
		System.out.println("Delete");
		service.deleteStudent(id);
		return "redirect:/list-users";
	}
	
	@RequestMapping(value = "/update-user", method = RequestMethod.GET)
	public String showUpdateStudentPage(ModelMap model, @RequestParam int id) {
		model.addAttribute("studentObj", service.retrieveStudent(id));
		return "user";
	}

	@RequestMapping(value = "/update-user", method = RequestMethod.POST)
	public String updateStudent(ModelMap model, @Valid Student user,
			BindingResult result) throws Exception {
		if (result.hasErrors())
			return "user";
		service.updateStudent(user);

		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-users";
	}
	

	
}