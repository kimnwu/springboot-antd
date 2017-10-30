package com.ucsmy.ucas.manage.ext;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 暂无描述
 *
 * @author ucs_leijinming
 * @since 2017/7/5
 */
@Data
public class SmsSendInput {
    @NotEmpty
    private String reveice;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private String systemId;
}