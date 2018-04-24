package fs.BMS.service.serviceimpl;

import fs.BMS.dao.AppointmentMapper;
import fs.BMS.dao.BookMapper;
import fs.BMS.dto.AppointExecution;
import fs.BMS.entity.Appointment;
import fs.BMS.entity.AppointmentKey;
import fs.BMS.entity.Book;
import fs.BMS.enums.AppointStateEnum;
import fs.BMS.exception.AppointException;
import fs.BMS.exception.LackNumberException;
import fs.BMS.exception.RepeatAppointException;
import fs.BMS.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public Book getBookById(long bookId) {
        return bookMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public List<Book> getBookList() {
        return bookMapper.selectAll(0, 10);
    }

    @Override
    @Transactional
    /**
     * 使用注解控制事务方法的优点： 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
     */
    public AppointExecution appoint(long bookId, long studentId) {
        try {
            //减一个库存以备借出
            int update = bookMapper.reduceNumber(bookId);
            //库存不足，抛出异常
            if (update <= 0) {
                throw new LackNumberException("库存不足");
            } else {
                int insert = appointmentMapper.insert(new Appointment(bookId, studentId, new Date()));
                //重复预约
                if (insert <= 0) {
                    throw new RepeatAppointException("重复预约");
                } else {
                    //预约成功
                    Appointment appointment = appointmentMapper.selectByPrimaryKey(new AppointmentKey(bookId, studentId));
                    //返回一个业务执行结果
                    return new AppointExecution(bookId, AppointStateEnum.SUCCESS);
                }
            }
        } catch (LackNumberException | RepeatAppointException e1) {
            throw e1;
        } catch (Exception e3) {
            logger.error(e3.getMessage(), e3);
            throw new AppointException("提交失败:" + e3.getMessage());
        }
    }
}
