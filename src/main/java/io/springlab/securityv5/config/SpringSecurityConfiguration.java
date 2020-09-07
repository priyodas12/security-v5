package io.springlab.securityv5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//enable web level security
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //set the type of authentication,username,password,roles
        auth.inMemoryAuthentication()
                .withUser("abcd")
                .password("dcba")
                .roles("DEV")
                .and()
                .withUser("xyz")
                .password("zyx")
                .roles("TESTER");
    }

    @Bean
    PasswordEncoder getPasswordEncoded(){
        return NoOpPasswordEncoder.getInstance();
    }
}
