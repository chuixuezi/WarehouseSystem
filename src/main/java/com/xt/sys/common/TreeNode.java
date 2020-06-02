package com.xt.sys.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    private Integer id;
    @JsonProperty("parentId")
    private Integer pId;
    private String title;
    private String icon;
    private String href;
    private Boolean spread;
    private List<TreeNode> children = new ArrayList<TreeNode>();

    /**
     * @param id
     * @param pId
     * @param title
     * @param spread
     * dtree的數據格式
     */
    public TreeNode(Integer id, Integer pId, String title, Boolean spread) {
        this.id = id;
        this.pId = pId;
        this.title = title;
        this.spread = spread;
    }

    public TreeNode(Integer id, Integer pId, String title
            , String icon, String href, Boolean spread) {
        this.id = id;
        this.pId = pId;
        this.title = title;
        this.icon = icon;
        this.href = href;
        this.spread = spread;
    }
}
