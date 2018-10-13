package com.antelope.android.tablayout.json;

import java.util.List;

public class result {

    private String stat;
    private List<data_item> data;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<data_item> getData() {
        return data;
    }

    public void setData(List<data_item> data) {
        this.data = data;
    }

}
