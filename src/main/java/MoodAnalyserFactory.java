import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserFactory {

    //method to return constructor
    public static Constructor getConstructor(String className, Class<?>... param) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
            return moodAnalyserClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.TypeOfException.NO_SUCH_CLASS, "Class not found.");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.TypeOfException.NO_SUCH_METHOD, "Method not found.");
        }
    }

    //method to return object
    public static Object createMoodAnalyser(Constructor<?> constructor, Object... message) {
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
    //method to return method object
    public static Object createMethod(Object object,String methodName){
        try {
           Method method = object.getClass().getMethod(methodName);
            return method.invoke(object);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
