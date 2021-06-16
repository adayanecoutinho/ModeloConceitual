package com.adayanecoutinho.SpringModeloConceitual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adayanecoutinho.SpringModeloConceitual.domain.Categoria;
import com.adayanecoutinho.SpringModeloConceitual.repositories.CategoriaRepository;
import com.adayanecoutinho.SpringModeloConceitual.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrada. Id:" + id
					+ ", tipo:" + Categoria.class.getName());
		}
		
		
		return obj.orElse(null);
	}

}
