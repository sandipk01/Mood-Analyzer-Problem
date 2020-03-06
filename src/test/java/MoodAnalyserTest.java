import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    private MoodAnalyser moodAnalyser;
    private String result;
    //test case for return sad
    @Test
    public void givenMessage_WhenAnalyse_ThenSadMood()
    {
        moodAnalyser=new MoodAnalyser();
        result=moodAnalyser.analyseMood("i am in sad mood");
        Assert.assertEquals("SAD",result);
    }
    //analyseMood method can just return happy to test else message
    @Test
    public void givenMessage_WhenAnalyse_ThenHappyMood()
    {
        moodAnalyser=new MoodAnalyser();
        result=moodAnalyser.analyseMood("“I am in Any Mood”");
        Assert.assertEquals("HAPPY",result);
    }
}
