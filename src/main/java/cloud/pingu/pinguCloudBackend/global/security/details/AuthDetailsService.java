package cloud.pingu.pinguCloudBackend.global.security.details;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import cloud.pingu.pinguCloudBackend.domain.user.entity.User;
import cloud.pingu.pinguCloudBackend.domain.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import cloud.pingu.pinguCloudBackend.global.exception.HttpException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		UUID id = UUID.fromString(username);
		User userByEmail =
			userRepository.findById(id).orElseThrow(() ->
				new HttpException(HttpStatus.NOT_FOUND, "해당 회원을 찾을 수 없습니다.")
			);
		return new AuthDetails(userByEmail);
	}
}
