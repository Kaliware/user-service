package br.com.kaliware.ms.user.repository.user;


import br.com.kaliware.ms.user.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

  Optional<User> findByEmailAndDeletedAtIsNull(String email);

  Page<User> findByDeletedAtIsNull(Pageable pageable);

  Optional<User> findByIdAndDeletedAtIsNull(UUID id);

  Collection<User> findAllByDeletedAtBefore(Instant thresholdDate);

}