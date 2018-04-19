package com.viewWorld.dao;

import com.viewWorld.entity.Appointment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class AppointmentMapperTest {

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Test
    public void testSelectByPrimaryKey() {
        Appointment appointment = new Appointment();
        appointment.setAppointTime(new Date());
        appointment.setBookId(1000L);
        appointment.setStudentId(1507080116L);
        appointmentMapper.insert(appointment);
        Appointment appointment1 = appointmentMapper.selectByPrimaryKey(appointment);

        System.out.println(appointment1);
    }
}
