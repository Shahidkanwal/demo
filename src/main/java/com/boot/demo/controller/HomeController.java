package com.boot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
//@RequestMapping(path = "/alien")
public class HomeController {

	
	@GetMapping(path = "/index")
	public String home() {
		return "index";
	}

	@GetMapping(path = "/register")
	public String register() {
		return "pages-register";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("login")
//	public String login(String name, HttpSession session) {
//		session.setAttribute("name", "Shahid");
//		return "login";
//	}
//	@RequestMapping("add")
//	public String add(String name, HttpSession session) {
//		session.setAttribute("name", "Shahid");
//		return "addalien";
//	}
//	@RequestMapping("search")
//	public String search() {
//		return "search";
//	}
//	@RequestMapping(path = "aliens" ,  produces = {"application/xml"})
//	@ResponseBody
//	public ResponseEntity<List<Alien>> aliens() {
//		List<Alien> aliens = alienRepo.findAll();
//		if (aliens.size() <=0) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//		
//		return ResponseEntity.of(Optional.of(aliens));
//	}
//	@RequestMapping("alien/{aid}")
//	@ResponseBody
//	public String alien(@PathVariable("aid") int aid) {
//		
//		return this.alienRepo.findById(aid).toString();
//	}
//	@RequestMapping(path = "saveAlien", method = RequestMethod.POST)
//	public String saveAlien(Alien alien) {
//		this.alienRepo.save(alien);
//		return "home";
//	}
//	
//
//	@RequestMapping(path = "getAlien", method = RequestMethod.POST)
//	public ModelAndView getAlien(Integer aid) {
//		
//		ModelAndView modelAndView = new ModelAndView("show");
//		Alien alien = this.alienRepo.findById(aid).orElse(new Alien());
//		modelAndView.addObject("alien",alien);
//		System.out.println(alien.toString());
//		return modelAndView;
//	}
//	@RequestMapping(path = "getTechAlien", method = RequestMethod.POST)
//	public ModelAndView getTechAlien(String atech) {
//		
//		ModelAndView modelAndView = new ModelAndView("show");
//		 List<Alien> list = this.alienRepo.findByAtech(atech);
//		 List<Alien> list2 = this.alienRepo.findByTechSorted("q mobile");
//
//		modelAndView.addObject("alien",list);
//		System.out.println(list2);
//		return modelAndView;
//	}
}
