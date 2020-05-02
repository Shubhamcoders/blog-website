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

import com.shubham.models.Post;
import com.shubham.services.PostService;

@Controller
public class PostController 
{
	
	
	@Autowired
	private PostService postService;
	
	@RequestMapping("/create-post")
	public String createpost(HttpServletRequest request)
	{
		return "createpost";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute Post post,BindingResult bindingResult,Model model)
	{
		postService.saveMyPost(post);
		//request.setAttribute("congrats","Congratulations!!!The post has been created successfully");
		//request.setAttribute("mode","MODE_POST");
		model.addAttribute("msg","Congratulations!!!The post has beed created successfully");
		return "homepage";
	}
	
	@GetMapping("/view-post")
	public String viewPost(Model model)
	{
		//request.setAttribute("post",postService.viewAllPost());
		model.addAttribute("post",postService.viewAllPost());
		return "viewpost";
	}
	
	@RequestMapping("/delete-post")
	public String deletePost(@RequestParam int id,Model model)
	{
		postService.deletePost(id);
		//request.setAttribute("post",postService.viewAllPost());
		model.addAttribute("post",postService.viewAllPost());
		return "viewpost";
	}

	@RequestMapping("/edit-post")
	public String updatepost(@RequestParam int id,Post p,Model model) {
	    Post postFromDb = postService.editPost(id);
	    //request.setAttribute("mode","MODE_UPDATE");
	    model.addAttribute("title",postFromDb.getTitle());
	    model.addAttribute("content", postFromDb.getContent());
	    postService.saveMyPost(postFromDb);
	    return "editpost";
	}
	
	@PostMapping("/save-edit-post")
	public String saveeditPost(@ModelAttribute Post post,BindingResult bindingResult,Model model)
	{
		postService.saveMyPost(post);
		model.addAttribute("msg","Congratulations!!!The post has been updated successfully");
		return "homepage";
	}
	
	@RequestMapping("/back")
	public String back(Model model) {
	    return "homepage";
	}
}
