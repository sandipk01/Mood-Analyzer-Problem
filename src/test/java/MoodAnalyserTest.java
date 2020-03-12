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
    public void givenTwoObjects_WhenEquals_ThenShouldReturnTrue() throws MoodAnalysisException {
        moodAnalyser=new MoodAnalyser();
        constructor=MoodAnalyserFactory.getConstructor("MoodAnalyser");
        object=MoodAnalyserFactory.createMoodAnalyser(constructor);
        resultBoolean=moodAnalyser.equals(object);
        Assert.assertTrue(resultBoolean);
    }

    @Test
    public void givenImproperClass_ThenShouldThrowNoSuchClassException(){
        moodAnalyser=new MoodAnalyser();
        try {
            constructor=MoodAnalyserFactory.getConstructor("MoodAnalyser");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.TypeOfException.NO_SUCH_CLASS,e.typeOfException);
        }
    }

    @Test
    public void givenImproperConstructorParameter_ThenShouldThrowNoSuchMethodException() {
        try {
            constructor=MoodAnalyserFactory.getConstructor("MoodAnalyser",Object.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.TypeOfException.NO_SUCH_METHOD,e.typeOfException);
        }
    }

    @Test
    public void givenTwoParameterizeObject_WhenEquals_ThenShouldReturnsTrue() throws MoodAnalysisException {
        moodAnalyser=new MoodAnalyser("sad");
        constructor=MoodAnalyserFactory.getConstructor("MoodAnalyser",String.class);
        object=MoodAnalyserFactory.createMoodAnalyser(constructor,"sad");
        resultBoolean=moodAnalyser.equals(object);
        Assert.assertTrue(resultBoolean);
    }

    @Test
    public void givenImproperClass_ThenShouldThrowNoClassFoundException() {
        try {
            constructor=MoodAnalyserFactory.getConstructor("MoodAnalyser",String.class);
            object=MoodAnalyserFactory.createMoodAnalyser(constructor,"I am in sad mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.TypeOfException.NO_SUCH_CLASS,e.typeOfException);
        }

    }
}
