package cloud.pingu.pinguCloudBackend.domain.workspace.controller;

import cloud.pingu.pinguCloudBackend.domain.workspace.dto.CreateWorkspaceRequest;
import cloud.pingu.pinguCloudBackend.domain.workspace.dto.DeleteWorkspaceRequest;
import cloud.pingu.pinguCloudBackend.domain.workspace.usecase.CreateWorkspaceUsecase;
import cloud.pingu.pinguCloudBackend.domain.workspace.usecase.DeleteWorkspaceUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/workspace")
public class WorkspaceController {

  private final CreateWorkspaceUsecase createWorkspaceUsecase;
  private final DeleteWorkspaceUsecase deleteWorkspaceUsecase;

  @PostMapping
  public ResponseEntity<Void> createWorkspace(
      @RequestBody CreateWorkspaceRequest request
  ) {
    createWorkspaceUsecase.execute(request);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping
  public ResponseEntity<Void> deleteWorkspace(
      @RequestBody DeleteWorkspaceRequest request
  ) {
    deleteWorkspaceUsecase.execute(request);
    return ResponseEntity.ok().build();
  }
}
