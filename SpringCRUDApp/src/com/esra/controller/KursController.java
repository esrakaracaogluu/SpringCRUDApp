package com.esra.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.esra.domain.Jobs;
import com.esra.domain.Kurs;
import com.esra.domain.Ogretmen;
import com.esra.service.KursServisi;

@Controller
@RequestMapping("/kurs")
public class KursController {

	@Autowired
	KursServisi kursServisi;

	@GetMapping("/list")
	public String getKurs(Model model, HttpSession oturum) {
		String isimKontrol = (String) oturum.getAttribute("oturum");
		if (isimKontrol == null) {
			return "redirect:/";
		} else {
			List<Kurs> kursList = kursServisi.getKurslar();
			model.addAttribute("kurs", kursList);
			return "kurs-list";
		}
	}

	@GetMapping("/kurs-ekle")
	public String kursEkle(Model model, HttpSession oturum) {
		String isimKontrol = (String) oturum.getAttribute("oturum");
		if (isimKontrol == null) {
			return "redirect:/";
		} else {
		Kurs kurs = new Kurs();
		model.addAttribute("kurs", kurs);
		return "kurs-form";
	}
	}
	@PostMapping("/kurs-kaydet")
	public String kursKaydet(@Valid @ModelAttribute("kurs") Kurs kurs, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "kurs-form";
		}
		kursServisi.saveKurs(kurs);
		return "redirect:/kurs/list";
	}

	@GetMapping("/kurs-guncelle")
	public String kursuGuncelle(@RequestParam("kursId") int krsId, Model model) {
		Kurs krs = kursServisi.getKurs(krsId);
		model.addAttribute("kurs", krs);
		return "kurs-form";
	}
	
	@GetMapping("/kurs-sil")
	public String kursSil(@RequestParam("kursId") int krsId) {
		kursServisi.deleteKurs(krsId);
		return "redirect:/kurs/list";
	}
	
	@ModelAttribute("ogretmenler")
	public Map<Integer, String> getJobs() {
		Map<Integer, String> ogretmen = new HashMap<Integer, String>();

		List<Ogretmen> ogretmenList = kursServisi.getOgretmenList();
		for (Ogretmen ogrt : ogretmenList) {
				ogretmen.put(ogrt.getOgrId(), ogrt.getOgretmenName());
			}

		
		return ogretmen;
	}

}
