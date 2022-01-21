package com.sms.controller;

import com.sms.com.service.SmsCondition;
import com.sms.com.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @Autowired
    private SmsService smsService;

    @PostMapping("/test")
    public void test(@RequestBody SmsCondition condition) {

        smsService.SmsSendMessage(condition.getMsisdn(), condition.getMsg(), condition.getSysType());
    }
}
