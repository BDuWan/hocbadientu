package com.duwan.hocba.config;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import com.duwan.hocba.dao.UserDao;
import com.duwan.hocba.object.UserObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
		http.authorizeHttpRequests((requests) -> 
				requests.requestMatchers("/notfound","/assets/**").permitAll()
				.requestMatchers("/hocsinh/**").hasAuthority("hs")
				.requestMatchers("/giaovien/**").hasAuthority("gv")
				.requestMatchers("/phuhuynh/**").hasAuthority("ph")
				.requestMatchers("/quanlytaikhoan/**").hasAnyAuthority("hs", "gv", "ph")
				.anyRequest().authenticated())
				.formLogin((form) -> 
				 form.loginPage("/login").permitAll()
				.failureUrl("/login")
				.successHandler((request, response, authentication) -> {
					handleRoleRedirection(request, response, authentication);
				}))
				.logout((logout) -> logout.permitAll().logoutSuccessUrl("/login"));

		return http.build();
	}

	private void handleRoleRedirection(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		String current_username = authentication.getName();
		HttpSession session = request.getSession();
	    session.setAttribute("current_username", current_username);
		if (roles.contains("hs")) {
			String linkhome = "/hocsinh/thoikhoabieu";
		    session.setAttribute("linkhome", linkhome);
			response.sendRedirect(linkhome);
		} else if (roles.contains("gv")) {
			response.sendRedirect("/giaovien");
		} else if (roles.contains("ph")) {
			String linkhome = "/phuhuynh/thoikhoabieu";
		    session.setAttribute("linkhome", linkhome);
			response.sendRedirect(linkhome);
		} else {
			response.sendRedirect("/notfound");
		}
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	private final UserDao userDao;

    public WebSecurityConfig(UserDao userDao) {
        this.userDao = userDao;
    }
   
    @Bean
	InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		List<UserObject> users = userDao.getAllUser();
		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        for (UserObject user : users) {
            UserDetails userDetails = User.withUsername(user.getTendangnhap())
            		.password(user.getPassword())
            		.authorities(user.getLoaitk())
            		.build();

            userDetailsManager.createUser(userDetails);
        }
        return userDetailsManager;
	}
}
