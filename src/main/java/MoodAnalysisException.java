public class MoodAnalysisException extends Exception {
    enum TypeOfException {
        NULL_EXCEPTION,EMPTY_EXCEPTION,NO_SUCH_CLASS,No_SUCH_METHOD
    }

    TypeOfException typeOfException;

    public MoodAnalysisException(TypeOfException typeOfException,String message){
        super(message);
        this.typeOfException=typeOfException;
    }
}
