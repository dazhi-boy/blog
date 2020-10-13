package com.dazhi.blogprovider.blog.entity;

import com.dazhi.blogprovider.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 景区图文介绍
 * </p>
 *
 * @author dazhi
 * @since 2020-10-13
 */
@ApiModel(value="AttractionsDetail对象", description="景区图文介绍")
public class AttractionsDetail extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图片路径")
    private String image;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "景区id")
    private Long attractionsId;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Long getAttractionsId() {
        return attractionsId;
    }

    public void setAttractionsId(Long attractionsId) {
        this.attractionsId = attractionsId;
    }

    @Override
    public String toString() {
        return "AttractionsDetail{" +
            "image=" + image +
            ", description=" + description +
            ", attractionsId=" + attractionsId +
        "}";
    }
}
