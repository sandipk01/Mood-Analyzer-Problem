public class MoodAnalysisException extends Exception {

    enum TypeOfException {
        NULL_EXCEPTION,EMPTY_EXCEPTION
    }

    TypeOfException typeOfException;

    public MoodAnalysisException(TypeOfException typeOfException,String message){
        super(message);
        this.typeOfException=typeOfException;
    }
}
