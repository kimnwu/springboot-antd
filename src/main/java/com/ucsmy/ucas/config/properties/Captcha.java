package com.ucsmy.ucas.config.properties;

import lombok.Data;

/**
 * 验证码策略配置参数
 * Created by cui on 2017/6/2.
 */
@Data
public class Captcha {
    private String border = "yes";// 图片边框，合法值：yes , no
    private String borderColor = "217,217,217";// 边框颜色，合法值： r,g,b (and optional alpha) 或者 white,black,blue.
    private int borderThickness = 1;// 边框厚度，合法值：>0
    private String fontColor = "16,142,233";// 字体颜色，合法值： r,g,b  或者 white,black,blue
    private String fontNames = "宋体,楷体,微软雅黑";// 字体
    private int fontSize = 40;// 字体大小
    private int imageWidth = 120;// 图片宽
    private int imageHeight = 45;// 图片高
    private int charLength = 4;// 验证码长度
    private int charSpace = 3;// 文字间隔
    private String charString = "0123456789";// 文本集合，验证码值从此集合中获取
    private String noiseColor = "black";// 干扰 颜色，合法值： r,g,b 或者 white,black,blue.
}
