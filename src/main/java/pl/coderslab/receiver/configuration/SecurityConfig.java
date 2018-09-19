package pl.coderslab.receiver.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.receiver.service.SpringDataUserDetailsService;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    DataSource dataSource;

    @Bean
    public SpringDataUserDetailsService customUserDetailsService()
    {
        return new SpringDataUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery("Select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery("Select u.username, r.role from users u join users_roles ur on u.id=ur.users_id join role r on r.role_id=ur.roles_role_id where u.username=?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**").fullyAuthenticated()
                .anyRequest().permitAll()
                .and().formLogin().loginPage("/login").successForwardUrl("/user/get-countries")
                ;
    }

}
