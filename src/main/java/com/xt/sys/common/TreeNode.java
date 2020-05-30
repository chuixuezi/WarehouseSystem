package com.xt.sys.common;

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
    private Integer pId;
    private String title;
    private String icon;
    private String href;
    private Boolean spread;
    private List<TreeNode> children = new ArrayList<TreeNode>();

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
