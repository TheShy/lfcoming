package com.zwtx.swing.lfcoming.MVP.Home.LFList;

import com.zwtx.swing.lfcoming.MVP.Entity.ListInfo;

/**
 * Created by Fliest on 2017/10/31.
 */

public class ListInfoBuilder {
    public int type;
    public int sortID;
    public String name;
    public String id;
    public int score;
    public int color;

    public static final ListInfoBuilder build() {
        return new ListInfoBuilder();
    }

    public ListInfoBuilder setSortID(int sortID) {
        this.sortID = sortID;
        return this;
    }

    public ListInfoBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ListInfoBuilder setID(String id) {
        this.id = id;
        return this;
    }

    public ListInfoBuilder setScore(int score) {
        this.score = score;
        return this;
    }

    public ListInfoBuilder setColor(int color) {
        this.color = color;
        return this;
    }

    public ListInfoBuilder setItemType(int type) {
        this.type = type;
        return this;
    }

    public ListInfo builder() {
        return new ListInfo(sortID, name, id, score, color,type);
    }


}
