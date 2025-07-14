package cloud.pingu.pinguCloudBackend.domain.workspace.repository;

import cloud.pingu.pinguCloudBackend.domain.workspace.entity.Workspace;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, UUID> {

}
