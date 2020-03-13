import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
        Object constructorObject = null;
        try {
            constructorObject = constructor.newInstance(message);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return constructorObject;
    }

    //method to return method object
    public static Object createMethod(Object object, String methodName) throws MoodAnalysisException {
        Method method = null;
        try {
            method = object.getClass().getMethod(methodName);
            return method.invoke(object);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.TypeOfException.NO_SUCH_METHOD, "Method not found.");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return method;
    }

    public static Field getField(Object classObject, String fieldName, String value) throws MoodAnalysisException {
        Field field = null;
        try {
            field = classObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(classObject, value);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.TypeOfException.NO_SUCH_FIELD,"No such field");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return field;
    }
}
