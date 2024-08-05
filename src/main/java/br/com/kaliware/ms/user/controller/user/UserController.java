package br.com.kaliware.ms.user.controller.user;

import br.com.kaliware.ms.user.controller.CrudController;
import br.com.kaliware.ms.user.record.user.UserRecord;
import br.com.kaliware.ms.user.service.CrudService;
import br.com.kaliware.ms.user.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController extends CrudController<UserRecord, UUID> {

  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @Override
  protected CrudService<UserRecord, UUID> getService() {
    return service;
  }

  @GetMapping("/{email}")
  public ResponseEntity<UserRecord> getById(@PathVariable String email) {
    UserRecord record = service.findByEmail(email);
    return ResponseEntity.ok(record);
  }

}
