import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyser createMoodAnalyser(){
        try {
            Class moodClass=Class.forName("MoodAnalyser");
            Constructor constructor=moodClass.getConstructor();
            Object moodObject=constructor.newInstance();
            return  (MoodAnalyser) moodObject;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException | InstantiationException |InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        MoodAnalyser moodAnalyser=new MoodAnalyser();
        Object object=MoodAnalyserFactory.createMoodAnalyser();
        System.out.println(object.equals(moodAnalyser));
    }
}
