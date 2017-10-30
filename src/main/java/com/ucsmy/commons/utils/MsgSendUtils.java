package com.ucsmy.commons.utils;

import com.ucsmy.ucas.manage.ext.RetMsg;
import com.ucsmy.ucas.manage.ext.SmsSendInput;
import ucsmy.usp.api.Msg;

public class MsgSendUtils {

    public static RetMsg smsSend(SmsSendInput input) throws Exception {
        RetMsg retMsg = handle(input);
        if(retMsg.isError()) {
            return retMsg;
        }
        if (!CheckoutUtils.isPhone(input.getReveice())) {
            return RetMsg.error("手机号格式不正确");
        }
        Msg.SmsSend(input.getSystemId(), input.getReveice(), input.getTitle(), input.getContent());
        return RetMsg.success("发送成功");
    }

    public static RetMsg emailSend(SmsSendInput input) throws Exception {
        RetMsg retMsg = handle(input);
        if(retMsg.isError()) {
            return retMsg;
        }
        if (!CheckoutUtils.isEmail(input.getReveice())) {
            return RetMsg.error("邮箱号格式不正确");
        }
        Msg.EmailSend(input.getSystemId(), input.getReveice(), input.getTitle(), input.getContent());
        return RetMsg.success("发送成功");
    }

    private static RetMsg handle(SmsSendInput input) {
        if (input == null) {
            return RetMsg.error("参数不能为空");
        }
        return HibernateValidateUtils.getError(input);
    }

}
