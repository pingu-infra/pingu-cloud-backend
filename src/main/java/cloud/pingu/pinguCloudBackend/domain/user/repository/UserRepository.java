package cloud.pingu.pinguCloudBackend.domain.user.repository;

import cloud.pingu.pinguCloudBackend.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
	Optional<User> findByPhoneNumber(String phoneNumber);

	Boolean existsByPhoneNumber(String phoneNumber);
}
