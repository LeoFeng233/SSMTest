package fs.BMS.entity;

public class AppointmentKey {
    private Long bookId;

    private Long studentId;

    public AppointmentKey() {
    }

    public AppointmentKey(Long bookId, Long studentId) {
        this.bookId = bookId;
        this.studentId = studentId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}