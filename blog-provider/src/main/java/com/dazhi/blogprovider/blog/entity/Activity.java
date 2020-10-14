package com.dazhi.blogprovider.blog.entity;

import com.dazhi.blogprovider.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 景区列表
 * </p>
 *
 * @author dazhi
 * @since 2020-10-14
 */
@ApiModel(value="Activity对象", description="景区列表")
public class Activity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标题")
    private String name;

    @ApiModelProperty(value = "关键字")
    private String keywords;

    @ApiModelProperty(value = "图片路径")
    private String image;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "主题id")
    private Long themeId;

    @ApiModelProperty(value = "所属用户id")
    private Long userId;

    @ApiModelProperty(value = "经度")
    private Long longitude;

    @ApiModelProperty(value = "纬度")
    private Long latitude;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "活动开始时间")
    private String beginTime;

    @ApiModelProperty(value = "活动结束时间")
    private String endTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
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
    public Long getThemeId() {
        return themeId;
    }

    public void setThemeId(Long themeId) {
        this.themeId = themeId;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }
    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Activity{" +
            "name=" + name +
            ", keywords=" + keywords +
            ", image=" + image +
            ", description=" + description +
            ", themeId=" + themeId +
            ", userId=" + userId +
            ", longitude=" + longitude +
            ", latitude=" + latitude +
            ", province=" + province +
            ", city=" + city +
            ", createTime=" + createTime +
            ", beginTime=" + beginTime +
            ", endTime=" + endTime +
        "}";
    }
}
