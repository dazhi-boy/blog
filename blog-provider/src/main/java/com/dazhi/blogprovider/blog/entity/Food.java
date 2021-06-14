package com.dazhi.blogprovider.blog.entity;

import com.dazhi.blogprovider.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 美食列表
 * </p>
 *
 * @author dazhi
 * @since 2021-06-11
 */
@ApiModel(value="Food对象", description="美食列表")
public class Food extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "食物名")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "图片路径")
    private String image;

    @ApiModelProperty(value = "分类：外卖，大餐，自己做")
    private Long type;

    @ApiModelProperty(value = "所属用户")
    private String openId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "Food{" +
            "name=" + name +
            ", description=" + description +
            ", image=" + image +
            ", type=" + type +
            ", openId=" + openId +
        "}";
    }
}
