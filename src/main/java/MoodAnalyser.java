import com.sun.org.apache.xpath.internal.operations.Mod;

public class MoodAnalyser {
    //variables
    private String message;

    //no arg constructor
    public MoodAnalyser(){ }

    //constructor with parameter
    public MoodAnalyser(String message) {
        this.message=message;
    }

    //method for accessing parameters
    public String analyseMood(String message) throws MoodAnalysisException{
        this.message=message;
        return analyseMood();
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
