public class MoodAnalysisException extends Exception {

    enum TypeOfException {
        NULL_EXCEPTION,EMPTY_EXCEPTION
    }

    TypeOfException typeOfException;

    public MoodAnalysisException(TypeOfException typeOfException,String message){
        super(message);
        this.typeOfException=typeOfException;
    }

    public MoodAnalysisException(String message, Throwable cause, TypeOfException typeOfException) {
        super(message, cause);
        this.typeOfException = typeOfException;
    }

    public MoodAnalysisException(Throwable cause, TypeOfException typeOfException) {
        super(cause);
        this.typeOfException = typeOfException;
    }
}
