import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.Objects;

public class MoodAnalyser {
    //Variables
    private String message;

    //No arg constructor
    public MoodAnalyser(){ }

    //Constructor with parameter
    public MoodAnalyser(String message) {
        this.message=message;
    }

    //Method for accessing parameters
    public String analyseMood(String message) throws MoodAnalysisException{
        this.message=message;
        return analyseMood();
    }

    //Overrides equals method to check objects are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyser that = (MoodAnalyser) o;
        return Objects.equals(message, that.message);
    }

    //Overrides hasCode method
    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    //analyseMood return SAD or HAPPY
    public String analyseMood() throws MoodAnalysisException{
        try {
            if (message.length()==0)
                throw new MoodAnalysisException(MoodAnalysisException.TypeOfException.EMPTY_EXCEPTION,"Please enter the message");
            if (message.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e){
            throw new MoodAnalysisException(MoodAnalysisException.TypeOfException.NULL_EXCEPTION,"message should not be null");
        }
    }
}
