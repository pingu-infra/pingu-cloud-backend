package cloud.pingu.pinguCloudBackend.domain.workspace.usecase;

import cloud.pingu.pinguCloudBackend.domain.workspace.dto.DeleteWorkspaceRequest;
import cloud.pingu.pinguCloudBackend.domain.workspace.entity.Workspace;
import cloud.pingu.pinguCloudBackend.domain.workspace.repository.WorkspaceRepository;
import cloud.pingu.pinguCloudBackend.global.exception.HttpException;
import cloud.pingu.pinguCloudBackend.global.util.UserUtil;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteWorkspaceUsecase {

  private final WorkspaceRepository workspaceRepository;
  private final CoreV1Api coreV1Api;
  private final UserUtil userUtil;

  @Transactional
  public void execute(DeleteWorkspaceRequest request) {
    Workspace result = workspaceRepository.findById(request.getId()).orElseThrow(
        () -> new HttpException(HttpStatus.NOT_FOUND, "워크스페이스가 존재하지 않습니다.")
    );

    if (result.getOwner() != userUtil.getUser()) {
      throw new HttpException(HttpStatus.FORBIDDEN, "본인의 워크스페이스가 아닙니다.");
    }

    try {
      coreV1Api.deleteNamespace(request.getId().toString()).execute();
    } catch (Exception e) {
      throw new HttpException(HttpStatus.BAD_GATEWAY, "클러스터에 문제가 발생했습니다.");
    }

    workspaceRepository.delete(result);
  }
}
