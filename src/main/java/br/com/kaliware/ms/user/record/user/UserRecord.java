package br.com.kaliware.ms.user.record.user;

import jakarta.validation.constraints.NotBlank;

import java.util.Set;
import java.util.UUID;

public record UserRecord(
   UUID id,

   @NotBlank(message = "First name must not be blank")
   String firstName,

   @NotBlank(message = "Last name must not be blank")
   String lastName,

   @NotBlank(message = "Email must not be blank")
   String email,

   String password,

   Set<RoleRecord> roles
) {
}
