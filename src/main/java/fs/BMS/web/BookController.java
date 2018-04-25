package fs.BMS.web;

import fs.BMS.dto.AppointExecution;
import fs.BMS.dto.Result;
import fs.BMS.entity.Book;
import fs.BMS.enums.AppointStateEnum;
import fs.BMS.exception.LackNumberException;
import fs.BMS.exception.RepeatAppointException;
import fs.BMS.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")// url:/模块/资源/{id}/细分 /seckill/list
public class BookController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String list(Model model) {
        List<Book> list = bookService.getBookList();
        model.addAttribute("list", list);
        //list.jsp + model = ModelAdndView
        return "list"; //WEB-INF/jsp/"list".jsp
    }

    @RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
    private String detail(@PathVariable("bookOd") Long bookId, Model model) {
        if (bookId == null) {
            return "redirect:/book/list";
        }
        Book book = bookService.getBookById(bookId);
        if (book == null) {
            return "forward:/book/list";
        }
        model.addAttribute("book", book);
        return "detail";
    }

    @RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST,
            produces = {"application/json; charset = utf-8"})
    @ResponseBody
    private Result<AppointExecution> appointExecutionResult(@PathVariable("bookId") Long bookId,
                                                            @RequestParam("studentId") Long studentId) {
        if (studentId == null) {
            return new Result<>(false,"学号不能为空");
        }
        AppointExecution appointExecution = null;
        try {
            appointExecution = bookService.appoint(bookId, studentId);
        }catch (LackNumberException e1) {
            appointExecution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
        }catch (RepeatAppointException e2) {
            appointExecution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
        }catch (Exception e) {
            appointExecution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
        }
        return new Result<AppointExecution>(appointExecution.getState() == 1, appointExecution);
    }
}
