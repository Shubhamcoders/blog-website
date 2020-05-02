//package com.shubham.controller;
//
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.shubham.models.Post;
//import com.shubham.models.User;
//import com.shubham.services.PostService;
//import com.shubham.services.UserService;
//
//@Controller
//public class ApplicationController 
//{
//	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private PostService postService;
//	
////
////	@RequestMapping("/")
////	public String hello()
////	{
////		return "index";
////	}
//	
////	@RequestMapping("/register")
////	public String registration1(Model model)
////	{
////		//request.setAttribute("mode", "MODE_REGISTER");
////		return "register";
////	}
////	
////	
////	@PostMapping("/save-user")
////	public String registerUser(@ModelAttribute User user,BindingResult bindingResult,Model model)
////	{
////		userService.saveMyUser(user);
////		model.addAttribute("msg","Account created successfully!!Proceed to login");
////		return "index";
////	}
////	@GetMapping("/show-users")
////	public String showAllUsers(Model model)
////	{
////		model.addAttribute("users",userService.showAllUsers());
////		//request.setAttribute("users",userService.showAllUsers());
////		//request.setAttribute("mode","ALL_USERS");
////		return "show_users";
////	}
////	
////	@RequestMapping("/delete-user")
////	public String deleteUser(@RequestParam int id,Model model)
////	{
////		userService.deletMyUser(id);
////		//request.setAttribute("users",userService.showAllUsers());
////		//request.setAttribute("mode","ALL_USERS");
////		model.addAttribute("users",userService.showAllUsers());
////		return "show_users";
////	}
////	
////	@RequestMapping("/edit-user")
////	public String updateUser(@RequestParam int id,User user,Model model) {
////	    User userFromDb = userService.editUser(id);
////	    //request.setAttribute("mode","MODE_UPDATE");
////	    model.addAttribute("username",userFromDb.getUsername());
////	    model.addAttribute("firstname",userFromDb.getFirstname());
////	    model.addAttribute("lastname",userFromDb.getLastname());
////	    model.addAttribute("age",userFromDb.getAge());
////	    model.addAttribute("password", userFromDb.getPassword());
////	    userService.saveMyUser(userFromDb);
////	    return "editpost";
////	}
////	
////	@PostMapping("/edit-save-user")
////	public String editUser(@ModelAttribute User user,BindingResult bindingResult,Model model)
////	{
////		userService.saveMyUser(user);
////		model.addAttribute("msg","Account updated successfully!!Proceed to login");
////		return "index";
////	}
////	
////	@RequestMapping("/login")
////	public String login(HttpServletRequest request)
////	{
////		//request.setAttribute("mode","MODE_LOGIN");
////		return "login";
////	}
////	
////	@RequestMapping("/login-user")
////	public String loginuser(@ModelAttribute User user,Model model)
////	{
////		if(userService.findByUsernameAndPassword(user.getUsername(),user.getPassword())!=null)
////		{
////			//request.setAttribute("success","Login Successful");
////			//request.setAttribute("mode","MODE_LOGIN");
////			
////			model.addAttribute("msg", "Login successful");
////			return "homepage";
////		}
////		else
////		{
////			//request.setAttribute("error","Invalid username or password");
////			//request.setAttribute("mode","MODE_LOGIN");
////			model.addAttribute("msg", "Invalid username or password");
////			return "error";
////		}
////	}
////	
////	@RequestMapping("/logout-user")
////	public String logoutuser(Model model)
////	{
////		//request.setAttribute("success","Thank you for using the application");
////		//request.setAttribute("mode","MODE_LOGOUT");
////		model.addAttribute("msg","Thank you for using the application!!!");
////		return "index";
////	}
////	
//	@RequestMapping("/create-post")
//	public String createpost(HttpServletRequest request)
//	{
//		return "createpost";
//	}
//	
//	@PostMapping("/create")
//	public String create(@ModelAttribute Post post,BindingResult bindingResult,Model model)
//	{
//		postService.saveMyPost(post);
//		//request.setAttribute("congrats","Congratulations!!!The post has been created successfully");
//		//request.setAttribute("mode","MODE_POST");
//		model.addAttribute("msg","Congratulations!!!The post has beed created successfully");
//		return "homepage";
//	}
//	
//	@GetMapping("/view-post")
//	public String viewPost(Model model)
//	{
//		//request.setAttribute("post",postService.viewAllPost());
//		model.addAttribute("post",postService.viewAllPost());
//		return "viewpost";
//	}
//	
//	@RequestMapping("/delete-post")
//	public String deletePost(@RequestParam int id,Model model)
//	{
//		postService.deletePost(id);
//		//request.setAttribute("post",postService.viewAllPost());
//		model.addAttribute("post",postService.viewAllPost());
//		return "viewpost";
//	}
//
//	@RequestMapping("/edit-post")
//	public String updatepost(@RequestParam int id,Post p,Model model) {
//	    Post postFromDb = postService.editPost(id);
//	    //request.setAttribute("mode","MODE_UPDATE");
//	    model.addAttribute("title",postFromDb.getTitle());
//	    model.addAttribute("content", postFromDb.getContent());
//	    postService.saveMyPost(postFromDb);
//	    return "editpost";
//	}
//	
//	@PostMapping("/save-edit-post")
//	public String saveeditPost(@ModelAttribute Post post,BindingResult bindingResult,Model model)
//	{
//		postService.saveMyPost(post);
//		model.addAttribute("msg","Congratulations!!!The post has been updated successfully");
//		return "homepage";
//	}
//	
//	@RequestMapping("/back")
//	public String back(Model model) {
//	    return "homepage";
//	}
//}
