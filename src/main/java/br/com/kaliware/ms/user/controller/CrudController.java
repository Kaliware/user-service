package br.com.kaliware.ms.user.controller;

import br.com.kaliware.ms.user.service.CrudService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class CrudController<T, ID> {

  protected abstract CrudService<T, ID> getService();

  @GetMapping
  public ResponseEntity<Page<T>> getAll(Pageable pageable) {
    Page<T> entities = getService().findAllPaged(pageable);
    return ResponseEntity.ok(entities);
  }

  @GetMapping("/{id}")
  public ResponseEntity<T> getById(@PathVariable ID id) {
    T entity = getService().findById(id);
    return ResponseEntity.ok(entity);
  }

  @PostMapping("/create")
  public ResponseEntity<T> create(@Valid @RequestBody T entity) {
    T createdEntity = getService().save(entity);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdEntity);
  }

  @PutMapping("/{id}")
  public ResponseEntity<T> update(@PathVariable ID id, @Valid @RequestBody T entity) {
    T updatedEntity = getService().update(id, entity);
    return ResponseEntity.ok(updatedEntity);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable ID id) {
    getService().delete(id);
    return ResponseEntity.noContent().build();
  }
}
