package cloud.pingu.pinguCloudBackend.domain.auth.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cloud.pingu.pinguCloudBackend.domain.auth.entity.RefreshToken;
import cloud.pingu.pinguCloudBackend.domain.auth.repository.RefreshTokenRepository;
import cloud.pingu.pinguCloudBackend.global.exception.HttpException;
import cloud.pingu.pinguCloudBackend.global.security.jwt.JwtProvider;

@Service
@Transactional
@RequiredArgsConstructor
public class LogoutUsecase {

	private final RefreshTokenRepository refreshTokenRepository;
	private final JwtProvider jwtProvider;

	public void execute(String resolveRefreshToken) {
		RefreshToken savedRefreshToken = jwtProvider.getSavedRefreshTokenByRefreshToken(resolveRefreshToken);

		if (!resolveRefreshToken.equals(savedRefreshToken.getRefreshToken())) {
			throw new HttpException(HttpStatus.FORBIDDEN, "올바르지 않은 리프레시 토큰입니다.");
		}

		refreshTokenRepository.delete(savedRefreshToken);
	}
}
