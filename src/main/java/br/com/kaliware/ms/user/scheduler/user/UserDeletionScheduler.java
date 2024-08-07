package br.com.kaliware.ms.user.scheduler.user;

import br.com.kaliware.ms.user.config.property.UserDeletionProperties;
import br.com.kaliware.ms.user.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserDeletionScheduler {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDeletionProperties deletionProperties;

    @Scheduled(cron = "#{@userDeletionProperties.cron}")
    public void scheduleUserDeletion() {
        userService.deleteOldUsers();
    }
}
