package cloud.pingu.pinguCloudBackend.domain.auth.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import cloud.pingu.pinguCloudBackend.domain.auth.repository.VerifyCountRepository;

@Component
@RequiredArgsConstructor
public class AuthScheduler {
    private final VerifyCountRepository verifyCountRepository;

    @Scheduled(cron = "0 0 0 * * *")
    public void resetVerifyCount(){
        verifyCountRepository.deleteAll();
    }
}
