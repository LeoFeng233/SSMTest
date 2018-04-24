package fs.BMS.service.serviceimpl;

import fs.BMS.dto.AppointExecution;
import fs.BMS.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testAppoint() {
        long bookId = 1000L;
        long studentId = 1507080116L;

        try {
            AppointExecution execution = bookService.appoint(bookId, studentId);
            System.out.println(execution);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
