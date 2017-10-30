package com.ucsmy.ucas.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.ucsmy.ucas.config.properties.Captcha;
import com.ucsmy.ucas.config.properties.UcsmyProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by cui on 2017/6/1.
 */
@Configuration
public class CaptchaConfig {

    @Bean
    public Producer captchaProducer(UcsmyProperties ucsmyProperties) {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Captcha captcha = ucsmyProperties.getCaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", captcha.getBorder());
        properties.setProperty("kaptcha.border.color", captcha.getBorderColor());
        properties.setProperty("kaptcha.border.thickness", String.valueOf(captcha.getBorderThickness()));
        properties.setProperty("kaptcha.textproducer.font.color", captcha.getFontColor());
        properties.setProperty("kaptcha.textproducer.font.names", captcha.getFontNames());
        properties.setProperty("kaptcha.textproducer.font.size", String.valueOf(captcha.getFontSize()));
        properties.setProperty("kaptcha.image.width", String.valueOf(captcha.getImageWidth()));
        properties.setProperty("kaptcha.image.height", String.valueOf(captcha.getImageHeight()));
        properties.setProperty("kaptcha.textproducer.char.length", String.valueOf(captcha.getCharLength()));
        properties.setProperty("kaptcha.textproducer.char.space", String.valueOf(captcha.getCharSpace()));
        properties.setProperty("kaptcha.textproducer.char.string", captcha.getCharString());
        properties.setProperty("kaptcha.noise.color", captcha.getNoiseColor());
        defaultKaptcha.setConfig(new Config(properties));
        return defaultKaptcha;
    }
}
