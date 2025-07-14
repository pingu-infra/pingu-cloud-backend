package cloud.pingu.pinguCloudBackend.global.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import cloud.pingu.pinguCloudBackend.domain.user.enums.Role;
import cloud.pingu.pinguCloudBackend.global.security.filter.JwtFilter;
import cloud.pingu.pinguCloudBackend.global.security.jwt.JwtProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
	private final JwtProvider jwtProvider;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		JwtFilter jwtFilter = new JwtFilter(jwtProvider);

		return http
			.authorizeHttpRequests(it -> it
				// 인증
				.requestMatchers("/auth/**").permitAll()
				// 테스트
				.requestMatchers(HttpMethod.GET, "/test/**").hasAnyAuthority(Role.ROLE_ADMIN.name(), Role.ROLE_USER.name())
				// 상태 확인
				.requestMatchers(HttpMethod.GET, "/actuator/**").permitAll()
			)
			.csrf(AbstractHttpConfigurer::disable)
			.formLogin(AbstractHttpConfigurer::disable)
			.httpBasic(AbstractHttpConfigurer::disable)
			.sessionManagement (it ->
				it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			)
			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
			.build();
	}
}
