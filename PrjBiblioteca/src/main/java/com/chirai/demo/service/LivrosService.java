package com.chirai.demo.service;

import com.chirai.demo.entity.Livro;
import com.chirai.demo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivrosService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Optional<Livro> findById(Long id) {
        return livroRepository.findById(id);
    }

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public Optional<Livro> update(Long id, Livro livroAtualizado) {
        return livroRepository.findById(id).map(livro -> {
            livro.setNome(livroAtualizado.getNome());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setEditora(livroAtualizado.getEditora());
            livro.setIsbn(livroAtualizado.getIsbn());
            return livroRepository.save(livro);
        });
    }

    public boolean delete(Long id) {
        return livroRepository.findById(id).map(livro -> {
            livroRepository.delete(livro);
            return true;
        }).orElse(false);
    }

    public List<Livro> buscarPorTitulo(String nome) {
        return livroRepository.findByNome(nome);
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }
}
