package com.practise.googlenewspractiseusingmvvm.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class source {

    @SerializedName("id")
    @Expose

    private String id;
    @SerializedName("name")
    @Expose
    private String name;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }


}
