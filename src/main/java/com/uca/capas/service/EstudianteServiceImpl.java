package com.uca.capas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	EstudianteDAO estudianteDAO;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		return estudianteDAO.findAll();
	}
	
	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException {
		estudianteDAO.save(estudiante);
		
	}

}
