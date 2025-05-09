package com.proyecto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ProjectConfig implements WebMvcConfigurer{
    @Override
public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/login").setViewName("login");
}
    
    @Bean
public UserDetailsService users() {
    UserDetails admin = User.builder()
            .username("admin")
            .password("{noop}123")
            .roles("ADMIN")
            .build();

    return new InMemoryUserDetailsManager(admin);
}


@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((request) -> request
            .requestMatchers("/login","/js/**", "/webjars/**").permitAll()
            .requestMatchers(
                    "/", "/index",
                "/entrenadores/**", "/entrenamientos/**",
                "/clientes/**", "/citas/**",
                "/acceso/**", "/entrenamientos/agregar/**",
                "/entrenamientos/modificar/**", "/entrenamientos/listado", "/entrenamientos/eliminar/**",
                "/entrenadores/modificar/**",
                "/entrenadores/agregar/**", "/entrenadores/listado", "/entrenadores/eliminar/**",
                "/clientes/agregar/**",
                "/clientes/modificar/**", "/clientes/listado",
                "/cita/**",
                "/cita/listado", "/cita/agregar/**", "/cita/modificar/**",
                "/cita/eliminar/**", "/acceso/listado", "/images/**"
            ).hasRole("ADMIN") // Solo ADMIN
        )
        .formLogin((form) -> form
            .loginPage("/login")
            .defaultSuccessUrl("/", true)
            .permitAll()

        )
        .logout((logout) -> logout.permitAll());

    return http.build();
}

}
