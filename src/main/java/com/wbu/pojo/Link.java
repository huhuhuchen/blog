package com.wbu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    /*
    id title summary url linktime sort
     */
    private int id;
    private String title;
    private String summary;
    private String url;
    private String linktime;
    private int sort;
}
