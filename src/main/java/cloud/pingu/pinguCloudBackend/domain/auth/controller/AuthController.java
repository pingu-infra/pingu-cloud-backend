package cloud.pingu.pinguCloudBackend.domain.auth.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cloud.pingu.pinguCloudBackend.domain.auth.dto.request.SendVerifyCodeRequest;
import cloud.pingu.pinguCloudBackend.domain.auth.dto.request.LoginRequest;
import cloud.pingu.pinguCloudBackend.domain.auth.dto.request.JoinRequest;
import cloud.pingu.pinguCloudBackend.domain.auth.dto.response.RefreshTokenResponse;
import cloud.pingu.pinguCloudBackend.domain.auth.dto.response.LoginResponse;
import cloud.pingu.pinguCloudBackend.domain.auth.usecase.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	private final JoinUsecase joinUsecase;
	private final LoginUsecase loginUsecase;
	private final RefreshTokenUsecase refreshTokenUsecase;
	private final LogoutUsecase logoutUsecase;

//	@PostMapping("/verify")
//	public ResponseEntity<Void> sendVerifyCode(
//		@Valid @RequestBody SendVerifyCodeRequest sendVerifyCodeRequest
//	){
//		sendVerifyCodeUsecase.execute(sendVerifyCodeRequest);
//		return ResponseEntity.ok().build();
//	}

	@PostMapping("/join")
	public ResponseEntity<Void> joinUser(
		@Valid @RequestBody JoinRequest joinRequest
	) {
		joinUsecase.execute(joinRequest);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(
		@Valid @RequestBody LoginRequest loginRequest
	) {
		LoginResponse response = loginUsecase.execute(loginRequest);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/logout")
	public ResponseEntity<Void> logout(
		@RequestHeader("Refresh-Token") String refreshToken
	) {
		String resolvedToken = refreshToken.substring(7);
		logoutUsecase.execute(resolvedToken);
		return ResponseEntity.ok().build();
	}

	@PatchMapping("/refresh")
	public ResponseEntity<RefreshTokenResponse> refreshToken(
			@RequestHeader("Refresh-Token") String refreshToken
	) {
		String resolvedToken = refreshToken.substring(7);
		RefreshTokenResponse response = refreshTokenUsecase.execute(resolvedToken);
		return ResponseEntity.ok(response);
	}
}
