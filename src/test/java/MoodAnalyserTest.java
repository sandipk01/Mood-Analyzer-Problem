import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    private MoodAnalyser moodAnalyser;
    private String result;

    @Test
    public void givenMessage_WhenAnalyse_ThenSadMood() throws MoodAnalysisException {
        moodAnalyser=new MoodAnalyser("I am in sad mood");
        result=moodAnalyser.analyseMood();
        Assert.assertEquals("SAD",result);
    }

    @Test
    public void givenMessage_WhenAnalyse_ThenHappyMood() throws MoodAnalysisException {
        moodAnalyser=new MoodAnalyser("I am in Any Mood");
        result=moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",result);
    }

    @Test
    public void givenNullMessageShouldThrowNullPointerException() {
        try {
            moodAnalyser=new MoodAnalyser(null);
            result=moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.TypeOfException.NULL_EXCEPTION,e.typeOfException);
        }
    }

    @Test
    public void givenMessageEmptyShouldThrowsEmptyException(){
        try {
            moodAnalyser=new MoodAnalyser("");
            result=moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.TypeOfException.EMPTY_EXCEPTION,e.typeOfException);
        }
    }
}
