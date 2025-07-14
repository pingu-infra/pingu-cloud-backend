package cloud.pingu.pinguCloudBackend.domain.runtimeConfig.entity;

import cloud.pingu.pinguCloudBackend.domain.app.entity.App;
import jakarta.persistence.*;
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
public class RuntimeConfig {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @OneToOne
    private App app;

    private Float cpu;

    private Integer memory;

    private Boolean autoStop;
}
