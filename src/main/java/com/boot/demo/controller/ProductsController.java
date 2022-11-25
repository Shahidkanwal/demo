package com.boot.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.boot.demo.dao.ProductDao;
import com.boot.demo.model.Product;

@Controller
public class ProductsController {
	
	@Autowired
	ProductDao productDao;
	
	@ModelAttribute
	public void addDatatoModel(Model m ) {
		
		List<String> list = new ArrayList<>();
		list.add("Tree - BB");
		list.add("Ornamental Lg");
		list.add("Ornamental Sm");
		list.add("Shrub");
		list.add("Groundcover");
		m.addAttribute("materiallist", list);
		
		List<String> multiselect = new ArrayList<>();
		multiselect.add("one");
		multiselect.add("two");
		multiselect.add("three");
		multiselect.add("four");
		m.addAttribute("multiselect", multiselect);
	}

	@GetMapping(path = "add")
	public String addProduct() {
		return "products/add-product";
	}
	
	@GetMapping(path = "edit")
	public ModelAndView editProduct(@RequestParam("product_id") Integer product_id) {
		
		ModelAndView modelAndView = new ModelAndView("products/edit-product");
		Product product = this.productDao.findById(product_id).get();
		modelAndView.addObject("product", product);
		return modelAndView;
	}
	
	@GetMapping(path = "list")
	public ModelAndView viewProducts() {
		
		List<Product> products = this.productDao.findAll();
		ModelAndView modelAndView = new ModelAndView("products/list-products");
		modelAndView.addObject("products",products);
		return modelAndView;
	}
	
	@PostMapping(path = "saveProduct")
	public String saveProduct(@ModelAttribute("product") @Valid Product product, BindingResult result) {
		
		if (result.hasErrors()) {
			return "products/add-product";
		} 
		productDao.save(product);
		return "redirect:/list";
	}
	
	@PostMapping(path = "updateProduct")
	public String updateProduct(@ModelAttribute("product") @Valid Product product, BindingResult result) {
		
		if (result.hasErrors()) {
			return "products/update-product";
		} 
		productDao.save(product);
		return "redirect:/list";
	}
	
	@GetMapping(path = "deleteProduct")
	public String deleteProduct(@RequestParam("product_id") Integer product_id) {
		this.productDao.deleteById(product_id);
		return "redirect:/list";
	}
}
