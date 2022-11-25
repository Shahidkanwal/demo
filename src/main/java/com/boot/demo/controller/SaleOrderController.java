package com.boot.demo.controller;

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
import com.boot.demo.model.SaleOrder;

@Controller
public class SaleOrderController {
	
	@Autowired
	SaleOrderDao sodDao;
	
	@Autowired
	RTJobDao jobDao;
	
	@GetMapping(path = "/addSaleorder")
	public ModelAndView addSaleorder(@RequestParam("job_id") Integer job_id) {
		ModelAndView model = new ModelAndView("saleorders/add-saleorder");

		RTJob job = jobDao.findById(job_id).get();
		model.addObject("job",job);
		return model;
	}
	
	@PostMapping(path = "/saveSO")
	public String saveSO(@ModelAttribute("saleorder") SaleOrder saleorder, @RequestParam("job_id") Integer job_id) {
		
		RTJob job = jobDao.findById(job_id).get();
		saleorder.setRtJob(job);
		System.out.println(saleorder.toString());
		sodDao.save(saleorder);

		return "redirect:/joblist";
	}
}
