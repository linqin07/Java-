package com.sms.com.service;

public interface SmsService {
    void SmsSendMessage(Long msisdn,String msg,Long sysType);
}
