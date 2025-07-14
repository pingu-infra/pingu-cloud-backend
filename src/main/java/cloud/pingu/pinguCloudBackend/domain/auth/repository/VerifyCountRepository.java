package cloud.pingu.pinguCloudBackend.domain.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cloud.pingu.pinguCloudBackend.domain.auth.entity.VerifyCount;

import java.util.Optional;

public interface VerifyCountRepository extends JpaRepository<VerifyCount, Long> {
	Optional<VerifyCount> findByPhoneNumber(String phoneNumber);
}
