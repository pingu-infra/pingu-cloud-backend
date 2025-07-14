package cloud.pingu.pinguCloudBackend.domain.auth.repository;

import org.springframework.data.repository.CrudRepository;
import cloud.pingu.pinguCloudBackend.domain.auth.entity.VerifyCode;

import java.util.Optional;

public interface VerifyCodeRepository extends CrudRepository<VerifyCode, String> {
    Optional<VerifyCode> findByPhoneNumber(String phoneNumber);
}
