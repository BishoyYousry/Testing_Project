package Exceptions;

public class InvalidCourseMarkException extends Exception {
    private static final long serialVersionUID = 1L;

    //Exception Messages
    public static final String INVALID_COURSE_MARK = "Course Mark is wrong, any course must have mark equal to 100";

    public InvalidCourseMarkException()
    {
        super();
    }

    public InvalidCourseMarkException(String message)
    {
        super(message);
    }
}
