package es.kitches.webapp.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Value("${auth0.issuer}")
    private String issuer;

    @Value("${auth0.audience}")
    private String audience;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("Configuring for Jwt token with iss {} & aud {}", issuer, audience);

        JwtWebSecurityConfigurer.forRS256(audience, issuer)
                .configure(http)
                .authorizeRequests()
                //.antMatchers("/login").permitAll()
                //.antMatchers(HttpMethod.GET, "/api/v1/dishes/**").hasAuthority("read:dishes");
                .antMatchers("**").permitAll();
               /*   
        http
        .authorizeRequests()
            .antMatchers("/", "/hello/*", "/login").permitAll()
            .anyRequest().authenticated()
            .and()
        .csrf().disable();*/
//
//        JwtWebSecurityConfigurer.forRS256(audience, issuer)
//        .configure(http)
//        .authorizeRequests()
//        .antMatchers(HttpMethod.GET, "/secure/**").fullyAuthenticated();
        //                .antMatchers(HttpMethod.GET, "/secure/**").hasAuthority("read:greeting");

    }
}
