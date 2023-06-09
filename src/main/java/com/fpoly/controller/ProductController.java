package com.fpoly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpoly.dao.ProductDAO;
import com.fpoly.entity.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;

	@RequestMapping("/product/sort")
	public String sort(Model model, @RequestParam("field") Optional<String> field) {
		Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
		model.addAttribute("field", field.orElse("price").toUpperCase());
		List<Product> items = productDAO.findAll(sort);
		model.addAttribute("items", items);
		return "product/sort";
	}

	@RequestMapping("/product/page")
	public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<Product> page = productDAO.findAll(pageable);
		model.addAttribute("page", page);
		return "product/page";
	}
}