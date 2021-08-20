package com.xigu.park.web.vo.nats;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import fastjson.AppUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.function.Predicate;

/**
 * 远程控制需要的消息传递实体
 */
@Data
@AllArgsConstructor
public class BarrierGateRemoteControlMsg implements Serializable {

    public BarrierGateRemoteControlMsg(){
        this.jsonObject=new JSONObject();
        this.initParam();
    }

    public BarrierGateRemoteControlMsg(String cmd, Boolean async){
        this();
        this.cmd=cmd;
        this.async=async;
    }

    public BarrierGateRemoteControlMsg(String cmd, Boolean async, String param){
        this.cmd=cmd;
        this.async=async;
        this.param=param;
        this.initParam();
    }

    public void initParam(){
        if(StringUtils.isEmpty(this.param)){
            this.param=this.jsonObject.fluentPut("cmdId", this.cmdId).toJSONString();
        }else{
            this.param=this.jsonObject.parseObject(this.param).fluentPut("cmdId", this.cmdId).toJSONString();
        }
    }


    @JSONField(serialize=false)
    private JSONObject jsonObject;
    /**
     * 车道id
     */
    private String channelID;
    /**
     * 命令
     */
    private String cmd;
    /**
     * 是否异步
     */
    @JSONField(serialize=false)
    private Boolean async=true;
    /**
     * 远程发送道闸命令，时传递的参数（json）
     */
    private String param;

    /**
     * 命令唯一标识符
     */
    private String cmdId= "";

    @JSONField(serialize=false)
    private CmdEnum cmdEnum;

    public String toString(){
        return this.jsonObject.toJSONString(this);
    }

    /**
     * 初始化远程控制命令枚举，用来验证改命令对应的参数是否合法
     * @return CmdEnum
     * @throws IllegalArgumentException
     */
    public CmdEnum initCmdEnum() throws IllegalArgumentException {
        return CmdEnum.valueOf(this.cmd).setBody(this);
    }

    public enum CmdEnum {
        Open("Open", PredicateEnum.defaultNotEmpty), Close("Close", PredicateEnum.defaultNotEmpty),
        PaySuccess("PaySuccess", PredicateEnum.paySuccess), ReBoot("ReBoot", PredicateEnum.defaultNotEmpty), GetSnapImg("GetSnapImg", PredicateEnum.getSnapImg),
        ReadInputStatus("ReadInputStatus", PredicateEnum.defaultNotEmpty),
        DispIO("DispIO", PredicateEnum.dispIO), SetDateTime("SetDateTime", PredicateEnum.setDateTime),
        NeedCharge("NeedCharge", PredicateEnum.needCharge);

        private String value;
        private PredicateEnum predicateEnum;
        private BarrierGateRemoteControlMsg body;
        /**
         * 预留属性，如果需要自定义一个验证错误的信息，枚举构造函数可直接定义设置该值
         * 目前默认统一校验不通过异常返回信息
         */
        private String errMsg="不合法的参数";

        CmdEnum(String value, PredicateEnum predicateEnum){
            this.value=value;
            this.predicateEnum=predicateEnum;
        }

        public String getValue() {
            return value;
        }

        public String getErrMsg() {
            return errMsg;
        }

        public boolean valid(){
            if(StringUtils.isEmpty(this.body.getChannelID())){
                this.errMsg="停车场道闸设备信息不能为空";
                return false;
            }
            return this.predicateEnum.ifMatch(this.body.getParam());
        }

        public CmdEnum setBody(BarrierGateRemoteControlMsg body) {
            this.body = body;
            return this;
        }
    }

    private enum PredicateEnum {
        defaultNotEmpty(p-> !AppUtil.isNullOrEmpty(p)),
        paySuccess(p-> {
            if(defaultNotEmpty.ifMatch(p)){
                try {
                    JSONObject paramObj = JSONObject.parseObject(p);
                    return StringUtils.isNotEmpty(paramObj.getString("dispMsg")) && StringUtils.isNotEmpty(paramObj.getString("dispTime"));
                } catch (Exception e) {

                }
            }
            return false;
        }),
        getSnapImg(p-> {
            if(defaultNotEmpty.ifMatch(p)){
                try {
                    JSONObject paramObj = JSONObject.parseObject(p);
                    return StringUtils.isNotEmpty(paramObj.getString("fileName")) && StringUtils.isNotEmpty(paramObj.getString("dispTime")) && paramObj.getString("fileName").indexOf(".jpg")>0;
                } catch (Exception e) {

                }
            }
            return false;
        }),
        dispIO(p-> {
            if(defaultNotEmpty.ifMatch(p)){
                try {

                    JSONObject paramObj = JSONObject.parseObject(p);
                    return paramObj.getInteger("color")!=null && paramObj.getInteger("vehicleType")!=null
                            && StringUtils.isNotEmpty(paramObj.getString("plate"))
                            && StringUtils.isNotEmpty(paramObj.getString("msg"))
                            && paramObj.getInteger("dispTime")!=null
                            && paramObj.getBoolean("isOpen")!=null;
                } catch (Exception e) {

                }
            }
            return false;
        }),
        setDateTime(p-> {
            if(defaultNotEmpty.ifMatch(p)){
                try {
                    JSONObject paramObj = JSONObject.parseObject(p);
                    return paramObj.getInteger("year")!=null && paramObj.getInteger("month")!=null
                            && paramObj.getInteger("day")!=null
                            && paramObj.getInteger("hour")!=null
                            && paramObj.getInteger("minute")!=null
                            && paramObj.getInteger("second")!=null;
                } catch (Exception e) {

                }
            }
            return false;
        }),
        needCharge(p-> {
            if(defaultNotEmpty.ifMatch(p)){
                try {
                    JSONObject paramObj = JSONObject.parseObject(p);
                    return StringUtils.isNotEmpty(paramObj.getString("plate")) && paramObj.getInteger("useTime")!=null
                            && StringUtils.isNotEmpty(paramObj.getString("money"))
                            && StringUtils.isNotEmpty(paramObj.getString("image"));
                } catch (Exception e) {

                }
            }
            return false;
        });
        private Predicate<String> value;
        PredicateEnum(Predicate<String> value){
            this.value=value;
        }

        public Predicate<String> getValue() {
            return value;
        }

        /**
         * 是否匹配
         *
         * @param param 远程控制携带的json字符串参数
         * @return
         */
        public boolean ifMatch(String param) {
            return this.getValue().test(param);
        }
    }
}
