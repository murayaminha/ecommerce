package br.com.rd.ecommerce.Config;

import br.com.rd.ecommerce.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http //HttpSecurity
                // nao bloqueia o banco com o XFRAME

                .headers()
                .frameOptions()
                .sameOrigin()
                .and()
                //Pedir que todas as rotas sejam autorizadas
                .authorizeRequests()

                .antMatchers("/login").hasAnyRole("USER", "ADMIN")

                //Tirar a sessao da aplicação.
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                //Ligar Config do HTTP Basic
                .and()
                .httpBasic()
                //Desabilitar o CSRF token
                .and()
                .csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
