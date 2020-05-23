package my.common.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import my.account.service.AccountService;

@Slf4j
@Component
public class LogInOutListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    AccountService accountService;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        String username = ((UserDetails)event.getAuthentication()
                .getPrincipal()).getUsername();
        accountService.loggingLogin(username);
    }

}
