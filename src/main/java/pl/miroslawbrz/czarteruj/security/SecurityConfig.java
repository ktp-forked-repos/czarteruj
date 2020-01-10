package pl.miroslawbrz.czarteruj.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/addUser").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/image-resource").permitAll()
                .antMatchers("/api/charters").permitAll()
                .antMatchers("/charterAdminPanel").hasAnyRole("ADMIN", "CHARTERADMIN")
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/")
                .and()
                .csrf().disable();
    }
}
