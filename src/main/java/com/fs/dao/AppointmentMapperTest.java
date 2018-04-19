package com.fs.dao;

import com.fs.entity.Appointment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class AppointmentMapperTest {

    //spring依赖注入
    @Autowired
    private AppointmentMapper appointmentMapper;


    /**
     * spring+mybatis整合初步测试
     * 测试数据库连接
     * 测试Mapper.xml及配置的正确性
     */
    @Test
    public void testSelectByPrimaryKey() {
        Appointment appointment = new Appointment();
        appointment.setAppointTime(new Date());
        appointment.setBookId(1000L);
        appointment.setStudentId(123456789L);
        appointmentMapper.insert(appointment);
        Appointment appointment1 = appointmentMapper.selectByPrimaryKey(appointment);

        System.out.println(appointment1);
    }
}
