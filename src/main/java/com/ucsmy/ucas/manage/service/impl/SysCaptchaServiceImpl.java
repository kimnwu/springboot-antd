package com.ucsmy.ucas.manage.service.impl;

import com.google.code.kaptcha.Producer;
import com.ucsmy.commons.utils.StringUtils;
import com.ucsmy.ucas.manage.service.SecurityService;
import com.ucsmy.ucas.manage.service.SysCaptchaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 图形验证码service
 *
 * @author chenqilin
 * @since 2017/7/13
 */
@Service
public class SysCaptchaServiceImpl implements SysCaptchaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysCaptchaServiceImpl.class);
    private final static int INVALID_TIME = 5 * 60;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private Producer captchaProducer;

    @Override
    public CaptchaBean getCaptcha(String securityCode) {
        if(StringUtils.isNotEmpty(securityCode))
            securityService.deleteSecurityCode(securityCode);
        String capText = captchaProducer.createText();
        securityCode = securityService.genSecurityCode(capText, INVALID_TIME, SecurityService.Business.CAPTCHA);
        BufferedImage image = captchaProducer.createImage(capText);
        return new CaptchaBean(securityCode, getImageBase64(image));
    }

    @Override
    public boolean checkCaptcha(String securityCode, String text) {
        if(text == null)
            return false;
        SecurityService.Security<String> security = securityService.getSecurityCode(securityCode, SecurityService.Business.CAPTCHA);
        securityService.deleteSecurityCode(securityCode);
        return security != null && text.equalsIgnoreCase(security.getData());
    }

    @Override
    public boolean checkCaptcha(HttpServletRequest request) {
        return checkCaptcha(request.getParameter("securityCode"), request.getParameter("captcha"));
    }

    private String getImageBase64(BufferedImage image) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "JPEG", out);
            return new String(Base64Utils.encode(out.toByteArray()));
        } catch (IOException e) {
            LOGGER.error("验证码图片流输出异常", e);
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                LOGGER.error("关闭验证码图片输出流异常", e);
            }
        }
        return "";
    }
}