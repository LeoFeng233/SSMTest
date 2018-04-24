package fs.BMS.dao;


import fs.BMS.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml"})
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void TestSelectAll() {
        List<Book> books = bookMapper.selectAll(0, 5);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void testReduceNumber() {

        int update = bookMapper.reduceNumber(1000);
        System.out.println(update);
        Book book = bookMapper.selectByPrimaryKey((long)1000);
        System.out.println(book);
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        Book book = new Book();
        book.setBookId(1000L);
        book.setNumber(10);

        int update = bookMapper.updateByPrimaryKeySelective(book);
        System.out.println(update);
    }
}
