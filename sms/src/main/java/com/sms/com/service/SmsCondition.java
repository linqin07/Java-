package com.sms.com.service;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class SmsCondition {
    Long msisdn;
    String msg;
    Long sysType;
}
