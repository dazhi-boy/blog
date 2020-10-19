package com.dazhi.blogprovider.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.dazhi.blogprovider.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 景区列表
 * </p>
 *
 * @author dazhi
 * @since 2020-10-13
 */
@ApiModel(value="Attractions对象", description="景区列表")
public class Attractions extends BaseEntity {

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

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "经度")
    private String longitude;

    @ApiModelProperty(value = "纬度")
    private String latitude;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "图片和介绍明细")
    @TableField(exist = false)
    private List<AttractionsDetail> attractionsDetailList = new ArrayList<>();

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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
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

    public List<AttractionsDetail> getAttractionsDetailList() {
        return attractionsDetailList;
    }

    public void setAttractionsDetailList(List<AttractionsDetail> attractionsDetailList) {
        this.attractionsDetailList = attractionsDetailList;
    }

}
