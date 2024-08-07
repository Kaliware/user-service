package br.com.kaliware.ms.user.record.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;


public record RoleRecord(
   UUID id,

   String authority
) {
}
