package com.ucsmy.ucas.config.properties;

import lombok.Data;

@Data
public class Redirect {
    private String pageUrl = "";
    private String apiUrl = "";
    private String loginUrl = "";
}
