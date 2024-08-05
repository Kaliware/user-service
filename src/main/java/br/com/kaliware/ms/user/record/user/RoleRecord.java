package br.com.kaliware.ms.user.record.user;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record RoleRecord(
   UUID id,

   @NotBlank(message = "Authority field must not be blank")
   String authority
) {
}
