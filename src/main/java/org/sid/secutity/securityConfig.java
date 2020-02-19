package org.sid.secutity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class securityConfig  extends WebSecurityConfigurerAdapter {

    /*protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        BCryptPasswordEncoder bcpe=getBCPE();
        auth.inMemoryAuthentication().withUser("admin").password(bcpe.encode("12345")).roles("ADMIN","USER");
        auth.inMemoryAuthentication().withUser("user1").password(bcpe.encode("12345")).roles("USER");

    }*/
    protected void configure(HttpSecurity http)throws Exception{
       // super.configure(http);
        http.csrf().disable();
       // http.formLogin();
       http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/categories/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers("/products/**").hasAnyAuthority("USERS");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }
//    @Bean
//    BCryptPasswordEncoder getBCPE(){
//
//        return new BCryptPasswordEncoder();
//
//
//    }

}