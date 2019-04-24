package com.hooli.hooli.javabean;

import java.util.ArrayList;

public class Dormitory{
    private int dormId;//宿舍id
    private String building;//楼名
    private String buildingNum;//楼号
    private String floor;//楼层
    private String dormitoryNum;//宿舍号
    private String dormitoryHead;//宿舍长

    //宿舍学生
    private ArrayList students = new ArrayList<>();

    public int getDormId() {
        return dormId;
    }

    public void setDormId(int dormId) {
        this.dormId = dormId;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getDormitoryNum() {
        return dormitoryNum;
    }

    public void setDormitoryNum(String dormitoryNum) {
        this.dormitoryNum = dormitoryNum;
    }



}