import sun.tools.java.ClassNotFound;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.format.TextStyle;

public class MoodAnalyserFactory {
    //this method returns the Object od MoodAnalyser
    public static MoodAnalyser createMoodAnalyser() throws MoodAnalysisException {
        try {
            Class moodClass=Class.forName("MoodAnalyser");
            Constructor constructor=moodClass.getConstructor(TextStyle.class);
            Object moodObject=constructor.newInstance();
            return  (MoodAnalyser) moodObject;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.TypeOfException.NO_SUCH_CLASS,"No such class found");
        } catch (IllegalAccessException | InstantiationException |InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.TypeOfException.NO_SUCH_METHOD,"No such method found");
        }
        return null;
    }

    public static void main(String[] args) throws MoodAnalysisException {
            MoodAnalyser moodAnalyser = new MoodAnalyser();
            Object object = createMoodAnalyser();
            System.out.println(object.equals(moodAnalyser));
    }
}
