import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    //method to return constructor
    public static Constructor getConstructor(String className,Class<?> ... param) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass=Class.forName(className);
            return moodAnalyserClass.getConstructor(param);
        } catch (ClassNotFoundException e){
            throw new MoodAnalysisException(MoodAnalysisException.TypeOfException.NO_SUCH_CLASS,"Class not found.");
        } catch(NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    //method to return object
    public static Object createMoodAnalyser(Constructor<?> constructor,Object ... message){
        try {
            return constructor.newInstance(message);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
