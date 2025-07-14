package cloud.pingu.pinguCloudBackend.domain.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import cloud.pingu.pinguCloudBackend.domain.user.enums.Role;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {
	@Id
	@UuidGenerator
	@GeneratedValue
	private UUID id;

	@Column(unique = true, nullable = false)
	private String phoneNumber;

	@Column(nullable = false)
	private String encodedPassword;

	@Enumerated(EnumType.STRING)
	private Role role;
}
