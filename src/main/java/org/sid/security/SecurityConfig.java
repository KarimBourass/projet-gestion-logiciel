package org.sid.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
				.userDetailsService(userDetailsService)
				.passwordEncoder(bCryptPasswordEncoder);  //specifier le type da hashage d'encodage
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				//ne pas géneré le csrf
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
				.authorizeRequests().antMatchers("/login/**","/register/**").permitAll()
		.and()
					.authorizeRequests().antMatchers("/articles-prive/**","/article/**").hasAuthority("AUTEUR")

		.and()
				.authorizeRequests().antMatchers("/comite/**").hasAuthority("ADMIN")


		.and()
				.authorizeRequests().anyRequest().authenticated()
		.and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}


	@Override
	public void configure(WebSecurity web) throws Exception {
		// acces public sans authentification
		web.ignoring().antMatchers("/articles/**");
	}





}
