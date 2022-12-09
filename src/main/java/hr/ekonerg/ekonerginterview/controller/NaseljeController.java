package hr.ekonerg.ekonerginterview.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import hr.ekonerg.ekonerginterview.entity.Naselje;
import hr.ekonerg.ekonerginterview.repository.NaseljeRepository;

@Controller
public class NaseljeController {

	@Autowired
	NaseljeRepository naseljeRepository;

	@GetMapping("/naselje/edit/{id}")
	public ModelAndView showEditNaselja(@PathVariable("id") long naseljeId, Model model) {
		return new ModelAndView("naseljeEdit").addObject("naselje", naseljeRepository.findById(naseljeId).get());
	}

	@PostMapping("/naselje/{id}")
	public ModelAndView updateNaselje(@PathVariable("id") long naseljeId, Naselje naselje, ModelMap model) {
		naseljeRepository.updateBrojStanovnikaByIdNaselje(naselje.getBrojStanovnika(),
															Calendar.getInstance().getTime().toInstant(), 
															naseljeId);
		return new ModelAndView("redirect:/", model);
	}

}
