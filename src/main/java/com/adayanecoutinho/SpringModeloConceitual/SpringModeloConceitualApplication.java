package com.adayanecoutinho.SpringModeloConceitual;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adayanecoutinho.SpringModeloConceitual.domain.Categoria;
import com.adayanecoutinho.SpringModeloConceitual.domain.Cidade;
import com.adayanecoutinho.SpringModeloConceitual.domain.Estado;
import com.adayanecoutinho.SpringModeloConceitual.domain.Produto;
import com.adayanecoutinho.SpringModeloConceitual.repositories.CategoriaRepository;
import com.adayanecoutinho.SpringModeloConceitual.repositories.CidadeRepository;
import com.adayanecoutinho.SpringModeloConceitual.repositories.EstadoRepository;
import com.adayanecoutinho.SpringModeloConceitual.repositories.ProdutoRepository;


@SpringBootApplication
public class SpringModeloConceitualApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;	
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringModeloConceitualApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		//* pra *
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		 
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));	
				
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		//1 pra *
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia",est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est1.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
	}

}
