package cloud.pingu.pinguCloudBackend.domain.app.entity;

import cloud.pingu.pinguCloudBackend.domain.app.enums.AppStatus;
import cloud.pingu.pinguCloudBackend.domain.workspace.entity.Workspace;
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
public class App {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    private String name;

    private String repositoryUrl;

    private String branch;

    private String buildCommand;

    private String runCommand;

    private String port;

    @Enumerated(EnumType.STRING)
    private AppStatus status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    private Workspace workspace;
}
