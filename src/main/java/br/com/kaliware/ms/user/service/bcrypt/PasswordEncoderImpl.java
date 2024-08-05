package br.com.kaliware.ms.user.service.bcrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderImpl implements PasswordEncoder {

  private final BCryptPasswordEncoder passwordEncoder;

  @Autowired
  public PasswordEncoderImpl(final BCryptPasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public String encode(final String rawPassword) {
    return passwordEncoder.encode(rawPassword);
  }

}
