package com.hooli.hooli.javabean;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author cky
 * 2019.4.19
 */
public class Dormitory4Transition implements Serializable {
    private int dormId;//宿舍id
    private String building;//楼名
    private String buildingNum;//楼号
    private String floor;//楼层
    private String dormitoryNum;//宿舍号
    private String dormitoryHead;//宿舍长
    private HashMap<String, String> health;

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

    public String getDormitoryHead() {
        return dormitoryHead;
    }

    public void setDormitoryHead(String dormitoryHead) {
        this.dormitoryHead = dormitoryHead;
    }

    public HashMap<String, String> getHealth() {
        return health;
    }

    public void setHealth(HashMap<String, String> health) {
        this.health = health;
    }
}
