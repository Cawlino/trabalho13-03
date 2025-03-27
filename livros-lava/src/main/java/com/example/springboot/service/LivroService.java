package com.example.springboot.service;

import com.example.springboot.model.Livro;
import com.example.springboot.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> getAllLivros() {
        return livroRepository.findAll();
    }

    public Optional<Livro> getLivroById(Long id) {
        return livroRepository.findById(id);
    }

    public Livro createLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro updateLivro(Long id, Livro livro) {
        Optional<Livro> existingLivro = livroRepository.findById(id);
        if (existingLivro.isPresent()) {
            livro.setId(id);
            return livroRepository.save(livro);
        }
        return null;
    }

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
