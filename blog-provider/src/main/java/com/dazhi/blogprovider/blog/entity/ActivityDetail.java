package com.dazhi.blogprovider.blog.entity;

import com.dazhi.blogprovider.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 活动图文介绍
 * </p>
 *
 * @author dazhi
 * @since 2020-10-14
 */
@ApiModel(value="ActivityDetail对象", description="活动图文介绍")
public class ActivityDetail extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标题")
    private String name;

    @ApiModelProperty(value = "图片路径")
    private String image;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "活动id")
    private Long activityId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
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
    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    @Override
    public String toString() {
        return "ActivityDetail{" +
            "name=" + name +
            ", image=" + image +
            ", description=" + description +
            ", activityId=" + activityId +
        "}";
    }
}
