package fs.BMS.dao;

import fs.BMS.entity.Appointment;
import fs.BMS.entity.AppointmentKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml"})
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
        appointment.setStudentId(2316549865L);
        int insert = appointmentMapper.insert(appointment);
        System.out.println("insert:" + insert);
        Appointment appointment1 = appointmentMapper.selectByPrimaryKey(appointment);

        System.out.println(appointment1);
    }

    @Test
    public void testDeletByPrimaryKey() {
        AppointmentKey appointment = new Appointment();
        appointment.setBookId(1000L);
        appointment.setStudentId(2316549865L);

        int delet = appointmentMapper.deleteByPrimaryKey(appointment);
        System.out.println("delet:" + delet);
    }
}
