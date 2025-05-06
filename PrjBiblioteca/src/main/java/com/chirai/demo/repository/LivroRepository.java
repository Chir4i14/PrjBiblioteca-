package com.chirai.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chirai.demo.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	@Query (value = "SELECT * FROM tb_Livro l WHERE LOWER(l.tb_Livro) LIKE %:nome%", nativeQuery=true)
	List<Livro> buscarPorTitulo(@Param("nome") String nome);
}

