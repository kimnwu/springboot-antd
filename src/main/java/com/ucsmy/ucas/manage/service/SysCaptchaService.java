package com.ucsmy.ucas.manage.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 图形验证码service
 *
 * @author chenqilin
 * @since 2017/7/13
 */

public interface SysCaptchaService {

    /**
     * 获取验证码
     * @return
     */
    CaptchaBean getCaptcha(String securityCode);

    /**
     * 校验验证码
     * @param securityCode 安全码
     * @param text 用户输入的验证码
     * @return
     */
    boolean checkCaptcha(String securityCode, String text);

    /**
     * 校验验证码
     * @param request HttpServletRequest
     */
    boolean checkCaptcha(HttpServletRequest request);

    class CaptchaBean {
        private String securityCode;// 安全码
        private String image;// 验证码base64图片

        public CaptchaBean(String securityCode, String image) {
            this.securityCode = securityCode;
            this.image = image;
        }

        public String getSecurityCode() {
            return securityCode;
        }

        public void setSecurityCode(String securityCode) {
            this.securityCode = securityCode;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
