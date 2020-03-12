import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyserTest {
    private MoodAnalyser moodAnalyser;
    private String result;
    private boolean resultBoolean;
    private Constructor constructor;
    private Object object;
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
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.TypeOfException.NULL_EXCEPTION,e.typeOfException);
        }
    }

    @Test
    public void givenMessageEmptyShouldThrowsEmptyException(){
        try {
            moodAnalyser=new MoodAnalyser("");
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.TypeOfException.EMPTY_EXCEPTION,e.typeOfException);
        }
    }

    @Test
    public void givenTwoObjects_WhenEquals_ThenShouldReturnTrue() {
        moodAnalyser=new MoodAnalyser();
        constructor=MoodAnalyserFactory.getConstructor();
        object=MoodAnalyserFactory.createMoodAnalyser(constructor);
        resultBoolean=moodAnalyser.equals(object);
        Assert.assertTrue(resultBoolean);
    }

}
