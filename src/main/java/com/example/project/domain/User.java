package com.example.project.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class User {
    @TableId(value = "userId")
    private String userId;
    private String userName;
    private String userSex;
    private String userDay;
    private String userAddress;
    private String userQq;
    private String userImg;
}
