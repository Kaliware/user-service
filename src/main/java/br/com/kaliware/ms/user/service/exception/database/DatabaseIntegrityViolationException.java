package br.com.kaliware.ms.user.service.exception.database;


public class DatabaseIntegrityViolationException extends DatabaseException {
  public DatabaseIntegrityViolationException(String message) {
    super(message);
  }

  public DatabaseIntegrityViolationException(String message, Throwable cause) {
    super(message, cause);
  }

  public DatabaseIntegrityViolationException(Throwable cause) {
    super(cause);
  }
}
