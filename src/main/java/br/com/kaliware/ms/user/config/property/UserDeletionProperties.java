package br.com.kaliware.ms.user.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "user.deletion")
public class UserDeletionProperties {

  private int days = 120;
  private String cron = "0 0 0 * * ?";


  public int getDays() {
    return days;
  }

  public void setDays(int days) {
    this.days = days;
  }

  public String getCron() {
    return cron;
  }

  public void setCron(String cron) {
    this.cron = cron;
  }
}
