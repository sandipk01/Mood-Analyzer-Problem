import sun.tools.java.ClassNotFound;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyser createMoodAnalyser() throws MoodAnalysisException {
        try {
            Class moodClass=Class.forName("MoodAnalyser");
            Constructor constructor=moodClass.getConstructor();
            Object moodObject=constructor.newInstance();
            return  (MoodAnalyser) moodObject;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.TypeOfException.NO_SUCH_CLASS,"class not found");
        } catch (IllegalAccessException | InstantiationException |InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {

        }
        return null;
    }

    public static void main(String[] args) throws MoodAnalysisException {
            MoodAnalyser moodAnalyser = new MoodAnalyser();
            Object object = createMoodAnalyser();
            System.out.println(object.equals(moodAnalyser));
    }
}
