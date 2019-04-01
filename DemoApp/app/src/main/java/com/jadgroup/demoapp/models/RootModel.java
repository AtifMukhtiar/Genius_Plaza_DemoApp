package com.jadgroup.demoapp.models;

public class RootModel {
    private static RootModel rootModel;
    Data data;

    private RootModel() {
        data = new Data();
    }

    public static RootModel getInstance() {
        if (rootModel == null) {
            rootModel = new RootModel();
        }
        return rootModel;
    }// end of getInstance

    public Data getData() {
        return data;
    }// end of getData

    public void setData(Data data) {
        this.data = data;
    }//end of setData
}
