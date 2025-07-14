package cloud.pingu.pinguCloudBackend.domain.envVar.entity;

import cloud.pingu.pinguCloudBackend.domain.app.entity.App;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnvVar {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @ManyToOne
    private App app;

    private String key;

    private String value;

    private Boolean isEncrypted;
}
