package topic14.task01;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class<?>[] classes = PackageUtil.getClasses("topic14.task01.classes");
        for (Class<?> clazz : classes) {
            Annotation[] annotations = clazz.getAnnotations();
            boolean autoInstantiate = Arrays.stream(annotations)
                    .anyMatch(annotation -> annotation.toString().contains("AutoInstantiate"));
            if (autoInstantiate) {
                try {
                    Constructor<?> constructor = clazz.getConstructor();
                    Object o = constructor.newInstance();
                    System.out.println(o);
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                         InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
