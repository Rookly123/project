package com.example.project.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

//get set方法等
@Data
//equals方法和hashcode方法
@EqualsAndHashCode(callSuper = false)
public class Singer {
    //mp下的自增id法
    @TableId(value="singerId")
    private Integer singerId;
    private String singerName;
    private String singerSex;
    private String singerHead;
    private String singerType;
    private String singerProfile;
    private String singerPortrait;
}
