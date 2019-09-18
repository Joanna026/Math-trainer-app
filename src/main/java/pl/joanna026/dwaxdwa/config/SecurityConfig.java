package pl.joanna026.dwaxdwa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.joanna026.dwaxdwa.model.services.SpringDataUserDetailsService;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return  PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?") ///jak nie ma kolumny enable , to 'true' w tym miejscu
                .authoritiesByUsernameQuery("SELECT username, authority_id FROM users WHERE username = ?");  ///zestaw kolumn nazwa, uprawnienia
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register", "/").anonymous()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/teacher/**").hasAnyRole("TEACHER", "ADMIN")
//                .antMatchers("/student/**").hasRole("STUDENT")
                .anyRequest().anonymous()
                .and()
                .formLogin()
//                .loginPage("/login")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .csrf().disable()
                ;
    }
}
