package com.dazhi.blogprovider.blog.entity;

import com.dazhi.blogprovider.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 教学视频
 * </p>
 *
 * @author dazhi
 * @since 2020-11-02
 */
@ApiModel(value="TutorialTv对象", description="教学视频")
public class TutorialTv extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标题")
    private String name;

    @ApiModelProperty(value = "图片路径")
    private String image;

    @ApiModelProperty(value = "视频路径")
    private String tv;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "视频分类id")
    private Long pid;

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
    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}
