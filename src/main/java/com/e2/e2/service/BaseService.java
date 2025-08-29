package com.e2.e2.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public abstract class BaseService<E, R extends JpaRepository<E, Long>> {

    protected final R repo;

    protected BaseService(R repo) { this.repo = repo; }

    public E create(E e) { return repo.save(e); }
    public List<E> findAll() { return repo.findAll(); }
    public Optional<E> findById(Long id) { return repo.findById(id); }
    public E update(Long id, E e) { return repo.save(e); }
    public void delete(Long id) { repo.deleteById(id); }
}
