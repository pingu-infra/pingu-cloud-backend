package cloud.pingu.pinguCloudBackend.global.thirdparty.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import cloud.pingu.pinguCloudBackend.global.thirdparty.sms.model.SmsMessage;
import cloud.pingu.pinguCloudBackend.global.thirdparty.sms.model.SmsType;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendSmsRequest {
    private SmsType type;
    private String from;
    private String content;
    private List<SmsMessage> messages;
}