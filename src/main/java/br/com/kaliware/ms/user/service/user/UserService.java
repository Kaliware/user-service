package br.com.kaliware.ms.user.service.user;

import br.com.kaliware.ms.user.record.user.UserRecord;
import br.com.kaliware.ms.user.service.CrudService;

import java.util.UUID;

public interface UserService extends CrudService<UserRecord, UUID> {

  UserRecord findByEmail(String email);

  void deleteOldUsers();

}
