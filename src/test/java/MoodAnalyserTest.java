import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    private MoodAnalyser moodAnalyser;
    private String result;
    @Test
    public void givenMessage_WhenAnalyse_ThenSadMood()
    {
        moodAnalyser=new MoodAnalyser("i am in sad mood");
        result=moodAnalyser.analyseMood();
        Assert.assertEquals("SAD",result);
    }
    @Test
    public void givenMessage_WhenAnalyse_ThenHappyMood()
    {
        moodAnalyser=new MoodAnalyser();
        result=moodAnalyser.analyseMood("I am in Any Mood");
        Assert.assertEquals("HAPPY",result);
    }
}
