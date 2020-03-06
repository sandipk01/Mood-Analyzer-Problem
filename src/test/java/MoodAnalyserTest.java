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
}
