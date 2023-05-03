package jo.jordan.JordanBookStore.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jo.jordan.JordanBookStore.repository.UserRepository;

import jo.jordan.JordanBookStore.service.UserService;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration  {

	private UserService userService;
	private UserRepository userRepository;

	public SecurityConfiguration(UserService userService, UserRepository userRepository) {
		super();
		this.userService = userService;
		this.userRepository = userRepository;
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authProvider());
//	}

	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		http.authorizeRequests()
				.requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
				.antMatchers(HttpMethod.GET, "/ books").permitAll()
				.antMatchers("/stores/{id}","/stores").hasAnyRole("storeAdmin","normalUser")
				.antMatchers("/stores/{id}/books").hasRole("storeAdmin")
				.anyRequest().authenticated()
				.and().formLogin().and().logout();

		http.csrf().disable().headers().frameOptions().disable();
		return http.build();
	}

//	@Bean
//	public DaoAuthenticationProvider authProvider() {
//		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//		daoAuthenticationProvider.setUserDetailsService(userService);
//		return daoAuthenticationProvider;
//	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
