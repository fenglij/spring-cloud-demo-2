package com.spring.cloud.model.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author fenglijian
 * @date 2022-10-27 11:08
 */
@ApiModel(value = "测试post命令")
public class TestCmd {

    @ApiModelProperty(value = "名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
