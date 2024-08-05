package br.com.kaliware.ms.user.service.exception.database;


public class DatabaseConnectionException extends DatabaseException {
  public DatabaseConnectionException(String message) {
    super(message);
  }

  public DatabaseConnectionException(String message, Throwable cause) {
    super(message, cause);
  }

  public DatabaseConnectionException(Throwable cause) {
    super(cause);
  }
}
