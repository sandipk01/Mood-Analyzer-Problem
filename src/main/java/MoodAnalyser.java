public class MoodAnalyser {
    public String analyseMood(String message)
    {
        if(message.equals("i am in sad mood"))
        {
            return "SAD";
        }
        else
        {
            return "HAPPY";
        }
    }
}
