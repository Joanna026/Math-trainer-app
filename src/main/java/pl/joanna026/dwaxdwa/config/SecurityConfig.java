package pl.joanna026.dwaxdwa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import pl.joanna026.dwaxdwa.model.services.SpringDataUserDetailsService;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;
    /** Public URLs. */
    private static final String[] PUBLIC_MATCHERS = {
            "/webjars/**",
            "/css/**",
            "/js/**",
            "/images/**",
            "/static/**",
            "/"
    };

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

////
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
                .authoritiesByUsernameQuery("SELECT users.username AS username, roles.authority AS role FROM users JOIN roles  on users.authority_id = roles.id " +
                        "WHERE username = ?");  ///zestaw kolumn nazwa, uprawnienia
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
//
//        List<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
//        if (activeProfiles.contains("dev")) {
//            http.csrf().disable();
//            http.headers().frameOptions().disable();
//        }

        http
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .antMatchers("/register", "/").anonymous()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/teacher/**").hasAnyRole("TEACHER", "ADMIN")
                .antMatchers("/student/**").hasRole("STUDENT")
                .anyRequest().anonymous()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/student/home")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .csrf().disable()
                ;
    }

}
