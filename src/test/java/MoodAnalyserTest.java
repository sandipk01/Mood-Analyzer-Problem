import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.Constructor;

public class MoodAnalyserTest {

    private MoodAnalyser moodAnalyser;
    private Object result;
    private boolean resultBoolean;
    private Constructor constructor;
    private Object object;

    @Test
    public void givenMessage_WhenAnalyse_ThenSadMood() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser("I am in sad mood");
        result = moodAnalyser.analyseMood();
        Assert.assertEquals("SAD", result);
    }

    @Test
    public void givenMessage_WhenAnalyse_ThenHappyMood() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser("I am in Any Mood");
        result = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY", result);
    }

    @Test
    public void givenNullMessageShouldReturnHappy() throws MoodAnalysisException {
            moodAnalyser = new MoodAnalyser(null);
            result = moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY", result);
    }

    @Test
    public void givenNullMessageShouldThrowNullPointerException() {
        try {
            moodAnalyser = new MoodAnalyser(null);
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.TypeOfException.NULL_EXCEPTION, e.typeOfException);
        }
    }

    @Test
    public void givenMessageEmptyShouldThrowsEmptyException() {
        try {
            moodAnalyser = new MoodAnalyser("");
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.TypeOfException.EMPTY_EXCEPTION, e.typeOfException);
        }
    }

    @Test
    public void givenTwoObjects_WhenEquals_ThenShouldReturnTrue() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser();
        constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
        object = MoodAnalyserFactory.createMoodAnalyser(constructor);
        resultBoolean = moodAnalyser.equals(object);
        Assert.assertTrue(resultBoolean);
    }

    @Test
    public void givenImproperClass_ThenShouldThrowNoSuchClassException() {
        moodAnalyser = new MoodAnalyser();
        try {
            constructor = MoodAnalyserFactory.getConstructor("MoodAnalyse");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.TypeOfException.NO_SUCH_CLASS, e.typeOfException);
        }
    }

    @Test
    public void givenImproperConstructorParameter_ThenShouldThrowNoSuchMethodException() {
        try {
            constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser", Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.TypeOfException.NO_SUCH_METHOD, e.typeOfException);
        }
    }

    @Test
    public void givenTwoParameterizeObject_WhenEquals_ThenShouldReturnsTrue() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser("sad");
        constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser", String.class);
        object = MoodAnalyserFactory.createMoodAnalyser(constructor, "sad");
        resultBoolean = moodAnalyser.equals(object);
        Assert.assertTrue(resultBoolean);
    }

    @Test
    public void givenImproperClass_ThenShouldThrowNoClassFoundException() {
        try {
            constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser", String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.TypeOfException.NO_SUCH_CLASS, e.typeOfException);
        }
    }

    @Test
    public void givenImproperConstructorParameter_ThenShouldThrowsNoSuchMethodException() {
        try {
            constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser", Integer.class, String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.TypeOfException.NO_SUCH_METHOD, e.typeOfException);
        }
    }

    @Test
    public void givenMessageHappy_ThenShouldReturnHappy() throws MoodAnalysisException {
        constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser", String.class);
        object = MoodAnalyserFactory.createMoodAnalyser(constructor, "I am in Happy Mood");
        result = MoodAnalyserFactory.createMethod(object, "analyseMood");
        Assert.assertEquals("HAPPY", result);
    }

    @Test
    public void givenImproperMethodName_ThenShouldThrowNoSuchMethodException() throws MoodAnalysisException {
        constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser", String.class);
        object = MoodAnalyserFactory.createMoodAnalyser(constructor, "I am in Happy Mood");
        try {
            MoodAnalyserFactory.createMethod(object, "analyseM");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.TypeOfException.NO_SUCH_METHOD, e.typeOfException);
        }
    }

    @Test
    public void givenHappyMessageDynamically_ThenShouldReturnHappy() throws MoodAnalysisException {
        constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
        object = MoodAnalyserFactory.createMoodAnalyser(constructor);
        MoodAnalyserFactory.getField(object, "message", "I am in Happy Mood");
        result = MoodAnalyserFactory.createMethod(object, "analyseMood");
        Assert.assertEquals("HAPPY", result);
    }

    @Test
    public void givenImproperField_ThenShouldThrowNoSuchFieldException() throws MoodAnalysisException {
        constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
        object = MoodAnalyserFactory.createMoodAnalyser(constructor);
        try {
            MoodAnalyserFactory.getField(object, "messe", "I am in Happy Mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.TypeOfException.NO_SUCH_FIELD,e.typeOfException);
        }
    }

    @Test
    public void givenNullField_ThenShouldThrowNoSuchFieldException() throws MoodAnalysisException {
        constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
        object = MoodAnalyserFactory.createMoodAnalyser(constructor);
        try {
            MoodAnalyserFactory.getField(object, "message", null);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.TypeOfException.NULL_EXCEPTION,e.typeOfException);
        }
    }
}
