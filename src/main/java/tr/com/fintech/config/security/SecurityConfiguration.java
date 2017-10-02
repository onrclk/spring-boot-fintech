package tr.com.fintech.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import tr.com.fintech.config.security.filter.JWTLoginFilter;
import tr.com.fintech.config.security.filter.JWTTokenAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(SecurityConfiguration.class);


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new FintechAuthenticationProdiver();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//                .antMatchers("/api/authenticate/**").permitAll()

        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                //  .antMatchers("/api/v3/activeUserToken").permitAll()
                .antMatchers("/api/v3/common/**").permitAll()
                .antMatchers(HttpMethod.POST, "api/v3/merchant/login").permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(new JWTLoginFilter(new AntPathRequestMatcher("/api/v3/merchant/login"), authenticationManager())
                        , UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .csrf()
                .disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**",
                        "/css/**", "/js/**", "/img/**", "/views/**", "/fonts/**", "/font-awesome/**", "/index.html", "/favicon.ico");
    }
}
