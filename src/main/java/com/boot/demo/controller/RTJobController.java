package com.boot.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.boot.demo.dao.RTJobDao;
import com.boot.demo.dao.SaleOrderDao;
import com.boot.demo.model.RTJob;

@Controller
public class RTJobController {
	
	@Autowired
	RTJobDao jobDao;
	
	@Autowired
	SaleOrderDao soDao;
	
	@GetMapping(path = "/addjob")
	public String addJob() {
		return "jobs/add-job";
	}
	
	@GetMapping(path = "/editJob")
	public ModelAndView editJob(@RequestParam("job_id") Integer job_id) {
		
		ModelAndView modelAndView = new ModelAndView("jobs/edit-job");
		RTJob job = this.jobDao.findById(job_id).get();
		modelAndView.addObject("job", job);
		return modelAndView;
	}
	@GetMapping(path = "/joblist")
	public ModelAndView joblist() {
		 ModelAndView modelAndView = new ModelAndView("jobs/list-jobs");
		 List<RTJob> jobs = jobDao.findAll();
		 
		 for (RTJob rtJob : jobs) {
			 System.out.println(rtJob.toString());
		 }
		 modelAndView.addObject("jobs", jobs);
		return modelAndView;
	}
	
	@PostMapping(path = "/saveJob")
	public String saveJob(@ModelAttribute("rtjob") RTJob job) {

		
//		RTJob job = jobDao.findById(19).get();
//		
//		SaleOrder so = new SaleOrder(0,"so name",10);
//		so.setRtJob(job);
//		soDao.save(so);
//		
//		
//		List<SaleOrder> solist = new ArrayList<>();
//		solist.add(so);
//		job.setSaleOrder(solist);
		
		System.out.println(job.toString());
		jobDao.save(job);

		return "redirect:/joblist";
	}
	
	@PostMapping(path = "/updateJob")
	public String updateJob(@ModelAttribute("rtjob") RTJob job) {
		jobDao.save(job);
		return "redirect:/joblist";
	}

}
