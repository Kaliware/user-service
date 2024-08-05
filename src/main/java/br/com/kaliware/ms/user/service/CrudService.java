package br.com.kaliware.ms.user.service;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<T, ID> {

  Page<T> findAllPaged(Pageable pageable);

  T findById(ID id);

  T save(@Valid T entity);

  T update(ID id, @Valid T entity);

  void delete(ID id);

}