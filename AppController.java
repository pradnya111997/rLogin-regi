package com.example.mysql.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController 
{
	@Autowired
	private userRepository repo;
@GetMapping("")
  public String viewHomePage()
  {
	return "index";
  }
@GetMapping("/register")
public String showsignupform(Model model)
{
	model.addAttribute("user",new user());
	return "signup form";
}
@PostMapping("/process_register")
public String processregstretion(user u)
{
	repo.save(u);
	return "Registretion Succesfull";
	
}
}
