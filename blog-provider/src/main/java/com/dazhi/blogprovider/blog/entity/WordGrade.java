package com.dazhi.blogprovider.blog.entity;

import com.dazhi.blogprovider.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 单词等级
 * </p>
 *
 * @author dazhi
 * @since 2021-06-22
 */
@ApiModel(value="WordGrade对象", description="单词等级")
public class WordGrade extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "级别code")
    private String code;

    @ApiModelProperty(value = "级别")
    private String grade;

    @ApiModelProperty(value = "图片路径")
    private String image;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "WordGrade{" +
            "code=" + code +
            ", grade=" + grade +
            ", image=" + image +
        "}";
    }
}
