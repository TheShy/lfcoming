package com.zwtx.swing.lfcoming.MVP.Entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Fliest on 2017/10/31.
 */

public class ListInfo implements MultiItemEntity {
    @Override
    public int getItemType() {
        return type;
    }

    public ListInfo(int sortId, String name, String id, int score, int color,int itemType) {
        this.sortId = sortId;
        this.name = name;
        this.id = id;
        this.score = score;
        this.color = color;
        this.type = itemType;
    }

    private int sortId;
    private String name;
    private String id;
    private int score;
    private int color;
    private int type;

    public int getSortId() {
        return sortId;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public int getColor() {
        return color;
    }


}
