package hr.ekonerg.ekonerginterview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import hr.ekonerg.ekonerginterview.entity.Zupanija;
import hr.ekonerg.ekonerginterview.repository.NaseljeRepository;
import hr.ekonerg.ekonerginterview.repository.ZupanijaRepository;

@Controller
public class MainController {

	@Autowired
	ZupanijaRepository zupanijaRepository;

	@Autowired
	NaseljeRepository naseljaRepository;

	@GetMapping(value = { "/" })
	public ModelAndView get() {
		return new ModelAndView("main").addObject("zupanije", zupanijaRepository.findAll())
				.addObject("zupanijeTop", zupanijaRepository.findZupanijeOrderedByBrojStanovnika())
				.addObject("naselja", naseljaRepository.findAll());

	}

	@GetMapping("/{id}")
	public ModelAndView showNaseljaByZupanija(@PathVariable("id") long zupanijaId, Model model) {
		return new ModelAndView("main").addObject("zupanije", zupanijaRepository.findAll())
				.addObject("zupanijeTop", zupanijaRepository.findZupanijeOrderedByBrojStanovnika())
				.addObject("naselja", naseljaRepository.findByZupanija(new Zupanija(zupanijaId, null, null, null)));
	}

}
