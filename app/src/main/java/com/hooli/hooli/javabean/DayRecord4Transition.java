package com.hooli.hooli.javabean;

import java.util.Date;

public class DayRecord4Transition {
    private String dayRecordId;
    private Date dayRecorddate;
    private String dormId;
    private int score;//分数
    private boolean balcony;
    private boolean ground;
    private boolean wc;
    private boolean illegalAppliances;//违规电器
    private String dayRecordDetailPic1;//记录细节(照片)1
    private String dayRecordDetailPic2;//记录细节(照片)2
    private String dayRecordDetailPic3;//记录细节(照片)3

    public String getDayRecordId() {
        return dayRecordId;
    }

    public void setDayRecordId(String dayRecordId) {
        this.dayRecordId = dayRecordId;
    }

    public Date getDayRecorddate() {
        return dayRecorddate;
    }

    public void setDayRecorddate(Date dayRecorddate) {
        this.dayRecorddate = dayRecorddate;
    }

    public String getDormId() {
        return dormId;
    }

    public void setDormId(String dormId) {
        this.dormId = dormId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public boolean isGround() {
        return ground;
    }

    public void setGround(boolean ground) {
        this.ground = ground;
    }

    public boolean isWc() {
        return wc;
    }

    public void setWc(boolean wc) {
        this.wc = wc;
    }

    public boolean isIllegalAppliances() {
        return illegalAppliances;
    }

    public void setIllegalAppliances(boolean illegalAppliances) {
        this.illegalAppliances = illegalAppliances;
    }

    public String getDayRecordDetailPic1() {
        return dayRecordDetailPic1;
    }

    public void setDayRecordDetailPic1(String dayRecordDetailPic1) {
        this.dayRecordDetailPic1 = dayRecordDetailPic1;
    }

    public String getDayRecordDetailPic2() {
        return dayRecordDetailPic2;
    }

    public void setDayRecordDetailPic2(String dayRecordDetailPic2) {
        this.dayRecordDetailPic2 = dayRecordDetailPic2;
    }

    public String getDayRecordDetailPic3() {
        return dayRecordDetailPic3;
    }

    public void setDayRecordDetailPic3(String dayRecordDetailPic3) {
        this.dayRecordDetailPic3 = dayRecordDetailPic3;
    }
}
