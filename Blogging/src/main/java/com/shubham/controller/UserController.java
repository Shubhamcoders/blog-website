package com.shubham.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shubham.models.User;
import com.shubham.services.UserService;

@Controller
public class UserController 
{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String hello()
	{
		return "index";
	}
	
	@RequestMapping("/register")
	public String registration1(Model model)
	{
		//request.setAttribute("mode", "MODE_REGISTER");
		return "register";
	}
	
	
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user,BindingResult bindingResult,Model model)
	{
		userService.saveMyUser(user);
		model.addAttribute("msg","Account created successfully!!Proceed to login");
		return "index";
	}
	@GetMapping("/show-users")
	public String showAllUsers(Model model)
	{
		model.addAttribute("users",userService.showAllUsers());
		//request.setAttribute("users",userService.showAllUsers());
		//request.setAttribute("mode","ALL_USERS");
		return "show_users";
	}
	
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id,Model model)
	{
		userService.deletMyUser(id);
		//request.setAttribute("users",userService.showAllUsers());
		//request.setAttribute("mode","ALL_USERS");
		model.addAttribute("users",userService.showAllUsers());
		return "show_users";
	}
	
	@RequestMapping("/edit-user")
	public String updateUser(@RequestParam int id,User user,Model model) {
	    User userFromDb = userService.editUser(id);
	    //request.setAttribute("mode","MODE_UPDATE");
	    model.addAttribute("username",userFromDb.getUsername());
	    model.addAttribute("firstname",userFromDb.getFirstname());
	    model.addAttribute("lastname",userFromDb.getLastname());
	    model.addAttribute("age",userFromDb.getAge());
	    model.addAttribute("password", userFromDb.getPassword());
	    userService.saveMyUser(userFromDb);
	    return "edituser";
	}
	
	@PostMapping("/edit-save-user")
	public String editUser(@ModelAttribute User user,BindingResult bindingResult,Model model)
	{
		userService.saveMyUser(user);
		model.addAttribute("msg","Account updated successfully!!Proceed to login");
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request)
	{
		//request.setAttribute("mode","MODE_LOGIN");
		return "login";
	}
	
	@RequestMapping("/login-user")
	public String loginuser(@ModelAttribute User user,Model model)
	{
		if(userService.findByUsernameAndPassword(user.getUsername(),user.getPassword())!=null)
		{
			//request.setAttribute("success","Login Successful");
			//request.setAttribute("mode","MODE_LOGIN");
			
			model.addAttribute("msg", "Login successful");
			return "homepage";
		}
		else
		{
			//request.setAttribute("error","Invalid username or password");
			//request.setAttribute("mode","MODE_LOGIN");
			model.addAttribute("msg", "Invalid username or password");
			return "error";
		}
	}
	
	@RequestMapping("/logout-user")
	public String logoutuser(Model model)
	{
		//request.setAttribute("success","Thank you for using the application");
		//request.setAttribute("mode","MODE_LOGOUT");
		model.addAttribute("msg","Thank you for using the application!!!");
		return "index";
	}
	
}