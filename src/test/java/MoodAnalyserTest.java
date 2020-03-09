import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    private MoodAnalyser moodAnalyser;
    private String result;

    @Test
    public void givenMessage_WhenAnalyse_ThenSadMood(){
        moodAnalyser=new MoodAnalyser("I am in sad mood");
        result=moodAnalyser.analyseMood();
        Assert.assertEquals("SAD",result);
    }

    @Test
    public void givenMessage_WhenAnalyse_ThenHappyMood(){
        moodAnalyser=new MoodAnalyser("I am in Any Mood");
        result=moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",result);
    }

    @Test
    public void givenNull_WhenNullPointerException_ThenHappy(){
        moodAnalyser=new MoodAnalyser(null);
        result=moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",result);
    }
}
