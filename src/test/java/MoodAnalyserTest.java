import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    private MoodAnalyser moodAnalyser;
    private String result;
    private boolean resultBoolean;
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
        object=MoodAnalyserFactory.createMoodAnalyser();
        resultBoolean=object.equals(moodAnalyser);
        Assert.assertTrue(resultBoolean);
    }

    @Test
    public void givenTwoObjects_WhenNotEquals_ThenShouldReturnFalse() throws MoodAnalysisException {
        MoodAnalyserTest moodAnalyserTest=new MoodAnalyserTest();
        object=MoodAnalyserFactory.createMoodAnalyser();
        resultBoolean=object.equals(moodAnalyserTest);
        Assert.assertFalse(resultBoolean);
    }

    @Test
    public void givenWrongClass_ThenShouldGiveClassNotFoundException() {
        moodAnalyser=new MoodAnalyser();
        try {
            object=MoodAnalyserFactory.createMoodAnalyser();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.TypeOfException.NO_SUCH_CLASS,e.typeOfException);
        }
    }

    @Test
    public void givenConstructorPassWrongParameters_ThenShouldReturnNoSuchMethodException() {
        try{
            MoodAnalyserFactory.createMoodAnalyser();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.TypeOfException.NO_SUCH_METHOD,e.typeOfException);
        }
    }
}
