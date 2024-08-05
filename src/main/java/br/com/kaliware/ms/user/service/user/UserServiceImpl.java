package br.com.kaliware.ms.user.service.user;

import br.com.kaliware.ms.user.entity.User;
import br.com.kaliware.ms.user.mapper.user.UserMapper;
import br.com.kaliware.ms.user.record.user.UserRecord;
import br.com.kaliware.ms.user.repository.UserRepository;
import br.com.kaliware.ms.user.service.exception.database.DatabaseIntegrityViolationException;
import br.com.kaliware.ms.user.service.exception.resource.ResourceInvalidException;
import br.com.kaliware.ms.user.service.exception.resource.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository repository;
  private final UserMapper mapper;

  @Autowired
  public UserServiceImpl(final UserRepository repository, final UserMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  @Transactional(readOnly = true)
  public Page<UserRecord> findAllPaged(final Pageable pageable) {
    return repository.findAll(pageable).map(mapper::entityToRecord);
  }

  @Override
  @Transactional(readOnly = true)
  public UserRecord findById(final UUID id) {
    return repository.findById(id)
        .stream()
        .map(mapper::entityToRecord)
        .findFirst()
        .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
  }

  @Override
  @Transactional
  public UserRecord save(@Valid UserRecord record) {
    try {
      if (nonNull(record.id()))
        throw new ResourceInvalidException("The provided resource has an ID and cannot be created.");

      if (isNull(record.password()) || record.password().isBlank())
        throw new ResourceInvalidException("Password cannot be empty.");

      User entity = mapper.recordToEntity(record);
      entity = repository.save(entity);

      return mapper.entityToRecord(entity);
    } catch (DataIntegrityViolationException e) {
      throw new DatabaseIntegrityViolationException("Integrity violation");
    }
  }

  @Override
  @Transactional
  public UserRecord update(UUID id, @Valid UserRecord record) {
    if (!repository.existsById(id))
      throw new ResourceNotFoundException("User not found with id: " + id);

    User entity = mapper.recordToEntity(record);
    entity.setId(id);
    entity = repository.save(entity);

    return mapper.entityToRecord(entity);
  }

  @Override
  @Transactional
  public void delete(UUID id) {
    try {
      if (!repository.existsById(id))
        throw new ResourceNotFoundException("User not found for deletion with ID: " + id);

      repository.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      throw new DatabaseIntegrityViolationException("Integrity violation");
    }
  }

  @Override()
  @Transactional(readOnly = true)
  public UserRecord findByEmail(String email) {
    return repository.findByEmail(email)
        .stream()
        .map(mapper::entityToRecord)
        .findFirst()
        .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
  }
}
