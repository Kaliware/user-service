package br.com.kaliware.ms.user.service.bcrypt;

import org.mapstruct.Named;

public interface PasswordEncoder {

  @Named("encode")
  String encode(String rawPassword);

}
