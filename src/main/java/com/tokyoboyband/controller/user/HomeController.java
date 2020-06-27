package com.tokyoboyband.controller.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tokyoboyband.dto.CategoryDTO;
import com.tokyoboyband.service.impl.CategoryService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/trang-chu" , method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("user/home");
		CategoryDTO categoryList = new CategoryDTO();
		categoryList.setListResult((ArrayList<CategoryDTO>)categoryService.findAll()); 
		mav.addObject("categoryList", categoryList);
		return mav;
	}
	
	@RequestMapping(value = "/dang-nhap" , method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value = "/dang-xuat" , method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		ModelAndView mav = new ModelAndView("redirect:/trang-chu");
		return mav;
	}
	
	@RequestMapping(value = "/accessDenied" , method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
}
