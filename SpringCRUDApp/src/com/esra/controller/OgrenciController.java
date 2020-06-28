package com.esra.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.esra.domain.Ogrenci;
import com.esra.service.OgrenciServisi;

@Controller
@RequestMapping("/ogrenci")
public class OgrenciController {

	@Autowired 
	OgrenciServisi ogrenciServisi;

	@GetMapping("/list")
	public String listOgrenci(Model model, HttpSession oturum) {
		String isimKontrol = (String) oturum.getAttribute("oturum");
		if (isimKontrol == null) {
			return "redirect:/";
		} else {
			
			List<Ogrenci> ogrList = ogrenciServisi.getOgrenciler();

			model.addAttribute("ogrenciler", ogrList);   

			return "ogrenci-list"; 
		}
	}

	@GetMapping("/ogrenci-ekle")
	public String ogrenciEkle(Model model, HttpSession oturum) {
		String isimKontrol = (String) oturum.getAttribute("oturum");
		if (isimKontrol == null) {
			return "redirect:/";
		} else {
			Ogrenci ogr = new Ogrenci();
			model.addAttribute("ogrenci", ogr);

			return "ogrenci-form";
		}
	}


	@GetMapping("/ogrenci-guncelle")
	public String ogrenciGuncelle(@RequestParam("ogrenciId") int ogrId, Model model) { 

		Ogrenci ogr = ogrenciServisi.getOgrenci(ogrId);
		model.addAttribute("ogrenci", ogr);

		return "ogrenci-form";
	}

	@GetMapping("/ogrenci-sil")
	public String ogrenciSil(@RequestParam("ogrenciId") int ogrId) {

		ogrenciServisi.deleteOgrenci(ogrId);

		return "redirect:/ogrenci/list";
	}

	@PostMapping("/ogrenci-kaydet")
	public String ogrenciKaydet(@Valid @ModelAttribute("ogrenci") Ogrenci ogr, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "ogrenci-form";
		}
		ogrenciServisi.saveOgrenci(ogr);
		return "redirect:/ogrenci/list";
	}

}
