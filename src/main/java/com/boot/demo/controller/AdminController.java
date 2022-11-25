package com.boot.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.boot.demo.config.CustomUserDetails;
import com.boot.demo.config.UserDetailsServiceImp;
import com.boot.demo.dao.UserDao;
import com.boot.demo.model.User;

@Controller
public class AdminController {
	@Autowired
	UserDao userDao;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private static String UPLOAD_FOLDER = "src/main/resources/static/assets/img/";
	
	@RequestMapping("profile")
	public ModelAndView profile() {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId= 13;
		if (principal instanceof UserDetails) {
		   CustomUserDetails details = (CustomUserDetails)principal;
		   userId = details.getUserId();
		}
		ModelAndView modelAndView = new ModelAndView("users-profile");
		User user = userDao.findById(userId).get();
		modelAndView.addObject("user",user);
		return modelAndView;
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(path = "/signupUser", method = RequestMethod.POST)
	public String signupUser(User user ) {
		System.out.println("heloo");
		user.setRole("ROLE_USER");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		this.userDao.save(user);
		return "redirect:/profile";
	}
	
	@RequestMapping(path = "/saveRegister", method = RequestMethod.POST)
	public String saveRegister(User user, @RequestParam("file") MultipartFile file) throws IOException {
		byte[] bytes = null;
		System.out.println("heloo");
		try {
			if (file.isEmpty()) {

				bytes = file.getBytes();
				Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
				user.setImageUrl("assets/img/"+ file.getOriginalFilename());
				Files.write(path, bytes);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setRole("ROLE_USER");
		this.userDao.save(user);
		return "redirect:/profile";
	}
	@RequestMapping(path = "/changePassword", method = RequestMethod.POST)
	public String changePassword(@RequestParam("user_id") Integer user_id, @RequestParam("password") String password, @RequestParam("newpassword") String newpassword, @RequestParam("renewpassword") String renewpassword) {
		User user = userDao.findById(user_id).get();
		
		if (!newpassword.isEmpty()&& !renewpassword.isEmpty()) {
			if (newpassword.equals(renewpassword)) {
				user.setPassword(bCryptPasswordEncoder.encode(newpassword));
				this.userDao.save(user);
				System.out.println(newpassword);
			}
		}
		return "redirect:/profile";
	}
}
