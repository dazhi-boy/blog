package com.dazhi.blogprovider.blog.entity;

import com.dazhi.blogprovider.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 主题表
 * </p>
 *
 * @author dazhi
 * @since 2020-10-12
 */
@ApiModel(value="Theme对象", description="主题表")
public class Theme extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主题名")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "图片路径")
    private String image;

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

    @Override
    public String toString() {
        return "Theme{" +
            "name=" + name +
            ", description=" + description +
            ", image=" + image +
        "}";
    }
}
