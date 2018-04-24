package fs.BMS.service;

import fs.BMS.dto.AppointExecution;
import fs.BMS.entity.Book;

import java.util.List;

public interface BookService {

    /**
     * 通过id查找一本书
     * @param bookId
     * @return
     */
    Book getBookById(long bookId);

    /**
     * 查找所有图书
     * @return
     */
    List<Book> getBookList();

    /**
     * 预约图书
     * @return
     */
    AppointExecution appoint(long bookid, long studentId);
}
