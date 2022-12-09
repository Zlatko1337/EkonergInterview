package hr.ekonerg.ekonerginterview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import hr.ekonerg.ekonerginterview.entity.Zupanija;
import hr.ekonerg.ekonerginterview.repository.ZupanijaRepository;

@Controller
public class ZupanijaController {

	@Autowired
	ZupanijaRepository zupanijaRepository;

	@GetMapping("/zupanija/edit/{id}")
	public ModelAndView showEditZupanije(@PathVariable("id") long zupanijaId, Model model) {
		return new ModelAndView("zupanijaEdit").addObject("zupanija", zupanijaRepository.findById(zupanijaId).get());
	}

	@PostMapping("/zupanija/{id}")
	public ModelAndView updateZupanija(@PathVariable("id") long zupanijaId, Zupanija zupanija, ModelMap model) {
		zupanijaRepository.save(zupanija);
		return new ModelAndView("redirect:/", model);
	}

	@PostMapping("/zupanija/delete/{id}") // TODO call @DeleteMapping("/zupanija/{id}")...
	public ModelAndView deleteZupanija(@PathVariable("id") long zupanijaId, ModelMap model) {
		zupanijaRepository.deleteById(zupanijaId);
		return new ModelAndView("redirect:/", model);
	}

}
