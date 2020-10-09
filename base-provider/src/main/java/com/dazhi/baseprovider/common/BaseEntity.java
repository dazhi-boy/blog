package com.dazhi.baseprovider.common;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

public class BaseEntity {
    private Long id;
    @Version
    private Integer version;
    @JsonIgnore
    @TableLogic(delval = "now()", value = "null")
    private LocalDateTime delTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDateTime getDelTime() {
        return delTime;
    }

    public void setDelTime(LocalDateTime delTime) {
        this.delTime = delTime;
    }
}
