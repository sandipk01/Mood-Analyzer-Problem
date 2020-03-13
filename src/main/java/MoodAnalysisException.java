public class MoodAnalysisException extends Exception {
    //types of Exceptions
    enum TypeOfException {
        NULL_EXCEPTION, EMPTY_EXCEPTION, NO_SUCH_CLASS, NO_SUCH_METHOD,NO_SUCH_FIELD
    }

    //declared exception
    TypeOfException typeOfException;

    //parameterized constructor
    public MoodAnalysisException(TypeOfException typeOfException, String message) {
        super(message);
        this.typeOfException = typeOfException;
    }
}
