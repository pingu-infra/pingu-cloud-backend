package cloud.pingu.pinguCloudBackend.domain.deployment.entity;

import cloud.pingu.pinguCloudBackend.domain.app.entity.App;
import cloud.pingu.pinguCloudBackend.domain.deployment.enums.DeploymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Deployment {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @ManyToOne
    private App app;

    @Enumerated(EnumType.STRING)
    private DeploymentStatus status;

    private String gitCommitHash;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime completedAt;
}
