package com.wbu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private Integer id;
    private String title;
    private String summary;
    private String content;
    private Integer vcount;
    private Integer pcount;
    private Date ptime;
    private Integer cid;
    private String tags;
    private  Integer sort;

    private Category category;
}
