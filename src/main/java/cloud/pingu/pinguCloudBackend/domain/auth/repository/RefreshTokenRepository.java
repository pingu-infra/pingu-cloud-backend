package cloud.pingu.pinguCloudBackend.domain.auth.repository;

import cloud.pingu.pinguCloudBackend.domain.auth.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, UUID> {
    void deleteById(UUID id);
}
