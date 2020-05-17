package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.service.EstudianteService;

@Controller
public class MainController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@RequestMapping("/inicio")
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("estudiante", new Estudiante());
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/formEstudiante")
	public ModelAndView init3(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors())
			mav.setViewName("index");
		else {
			estudianteService.save(estudiante);
			mav.addObject("listado");
			mav.addObject("estudiante", new Estudiante());
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView init2() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante>estudiantes = null;
		
		try {
			estudiantes = estudianteService.findAll();
		} catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("listado");
		return mav;
	}
	

}
