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
    public String analyseMood(String message) {
        this.message=message;
        return analyseMood();
    }

    //analyseMood return SAD or HAPPY
    public String analyseMood() {
        if(message.contains("sad"))
            return "SAD";
        else
            return "HAPPY";
    }
}
