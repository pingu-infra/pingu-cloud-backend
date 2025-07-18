package cloud.pingu.pinguCloudBackend.domain.auth.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SendVerifyCodeRequest {
	@Pattern(
		regexp = "^01[0-9]{8,9}$",
		message = "유효한 휴대폰 번호 형식이 아닙니다."
	)
	private String phoneNumber;
}