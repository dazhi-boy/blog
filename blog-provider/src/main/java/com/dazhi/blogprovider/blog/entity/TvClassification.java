package com.dazhi.blogprovider.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.dazhi.blogprovider.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 视频分类
 * </p>
 *
 * @author dazhi
 * @since 2020-11-04
 */
@ApiModel(value="TvClassification对象", description="视频分类")
public class TvClassification extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主题名")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "父标签")
    private Long pid;

    @ApiModelProperty(value = "层级")
    private Long level;

    @TableField(exist = false)
    private List<TvClassification> child = new ArrayList<>();

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
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public List<TvClassification> getChild() {
        return child;
    }

    public void setChild(List<TvClassification> child) {
        this.child = child;
    }
}
