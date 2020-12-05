package com.dazhi.word.core.entity;

import com.dazhi.word.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 单词表
 * </p>
 *
 * @author dazhi
 * @since 2020-12-02
 */
@ApiModel(value="Word对象", description="单词表")
public class Word extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "词")
    private String term;

    @ApiModelProperty(value = "翻译")
    private String translate;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "出现次数")
    private Integer frequency;

    @ApiModelProperty(value = "级别")
    private String grade;

    @ApiModelProperty(value = "所属用户")
    private Long userId;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
    public String getStatus() {
        return status;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Word{" +
            "term=" + term +
            ", status=" + status +
            ", frequency=" + frequency +
            ", grade=" + grade +
            ", userId=" + userId +
        "}";
    }
}
