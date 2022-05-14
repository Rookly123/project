package com.example.project.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Music {
    @TableId(value = "musicId")
    private Integer musicId;
    private String musicName;
    private String musicAddress;
    private String musicImg;
    private String lyricsAddress;
    private Integer clickNumber;
    private String musicType;
}
