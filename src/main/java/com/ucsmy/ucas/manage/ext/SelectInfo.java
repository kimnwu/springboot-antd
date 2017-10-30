package com.ucsmy.ucas.manage.ext;

import com.ucsmy.commons.bean.BaseNode;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 下拉列表数据
 */
@Data
@NoArgsConstructor
public class SelectInfo extends BaseNode {
    private String name;

    @Builder
    public SelectInfo(String id, String name) {
        super(id);
        this.name = name;
    }

}
