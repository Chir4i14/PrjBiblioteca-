package com.chirai.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chirai.demo.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}

