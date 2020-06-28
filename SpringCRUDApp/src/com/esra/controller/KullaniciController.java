package com.esra.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.esra.domain.Kullanici;
import com.esra.service.KullaniciServisi;

@Controller
public class KullaniciController {

	@Autowired
	 KullaniciServisi kullaniciServisi;
	


	@RequestMapping("/")
	public String loginEkraný(Model model) {
		Kullanici kullanici = new Kullanici();

		model.addAttribute("kullanici", kullanici);
		return "login";
	}

	@PostMapping("/baglan")
	public String girisYap(@Valid @ModelAttribute("kullanici") Kullanici login, BindingResult bindingResult, ModelMap model, HttpSession oturum) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "login";
		}
		boolean userExists = kullaniciServisi.findUser(login.getUsername(), login.getPassword());
		
		if(userExists) {
			oturum.setAttribute("oturum", login.getUsername());
			return "secim";
		}else {
			
			return "login";
		}
	
	}


}
