package cloud.pingu.pinguCloudBackend.domain.workspace.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteWorkspaceRequest {

  @NotBlank
  private UUID id;
}
