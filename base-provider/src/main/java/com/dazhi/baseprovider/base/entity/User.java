package com.dazhi.baseprovider.base.entity;

import com.dazhi.baseprovider.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author dazhi
 * @since 2020-10-09
 */
@ApiModel(value="User对象", description="用户表")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
            "username=" + username +
            ", password=" + password +
        "}";
    }
}
