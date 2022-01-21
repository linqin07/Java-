package com.sms.com.service;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 动态调用
     */
    @Override
    public void SmsSendMessage(Long msisdn,String msg,Long sysType) {
        logger.info("msisdn:{},msg:{},sysType:{}",msisdn,msg,sysType);
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client =null;
        try {
            logger.info("开始请求，url: {}", "http://135.10.143.11:18150/obomc/services/bomcSmsService?wsdl");
            client = dcf.createClient("http://135.10.143.11:18150/obomc/services/bomcSmsService?wsdl");
            // 需要密码的情况需要加上用户名和密码
            // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
            Object[] objects = new Object[0];
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("insertSms", msisdn, msg, sysType);
            logger.info("返回数据:" + objects[0]);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }finally {
            if (client!=null) {
                client.destroy();
            }

        }
    }
}
