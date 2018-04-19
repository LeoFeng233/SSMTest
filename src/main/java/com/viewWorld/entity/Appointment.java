package com.viewWorld.entity;

import java.util.Date;

public class Appointment extends AppointmentKey {
    private Date appointTime;

    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "bookId=" + getBookId() +
                ",studentId=" + getStudentId() +
                ",appointTime=" + appointTime +
                ", book=" + book +
                '}';
    }
}