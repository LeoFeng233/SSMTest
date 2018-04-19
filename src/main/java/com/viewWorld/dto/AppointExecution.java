package com.viewWorld.dto;

import com.viewWorld.entity.Appointment;
import com.viewWorld.enums.AppointStateEnum;

public class AppointExecution {

    //图书ID
    private long bookId;
    //预约结果状态
    private int state;
    //预约结果状态信息
    private String stateInfo;
    //预约成功对象
    private Appointment appointment;

    public AppointExecution() {
    }
    //预约失败构造器
    public AppointExecution(long bookId, AppointStateEnum stateEum) {
        this.bookId = bookId;
        this.state = stateEum.getState();
        this.stateInfo = stateEum.getStateInfo();
    }
    //预约成功构造器
    public AppointExecution(long bookId, AppointStateEnum stateEum, Appointment appointment) {
        this(bookId, stateEum);
        this.appointment = appointment;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

}
