package customAnnotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomAnnotationsApp {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        // create a variable without using it and don't show warning -> Variable 'caste' is never used
        @SuppressWarnings("unused")
        String caste;

        Vehicle vehicle = new Vehicle("AUDI-M.2");
        Tool tool = new Tool("Driver");

        if(vehicle.getClass().isAnnotationPresent(CustomAnnotationOne.class)) {
            System.out.println("CustomAnnotationOne IS PRESENT :)");
        }
        else {
            System.out.println("CustomAnnotationOne IS NOT PRESENT :(");
        }


        for (Method method: vehicle.getClass().getDeclaredMethods()) {

            if (method.isAnnotationPresent(CustomAnnotationTwo.class)) {

                CustomAnnotationTwo annotationTwo = method
                        .getAnnotation(CustomAnnotationTwo.class);

                for(int item = 0; item < annotationTwo.times(); item++){
                    method.invoke(vehicle);
                }

            }
        }

        for (Field field: vehicle.getClass().getDeclaredFields()) {

            if (field.isAnnotationPresent(CustomAnnotationThree.class)) {

                Object object = field.get(vehicle);

                if (object instanceof String convertedValue) {
                    System.out.println(convertedValue.toUpperCase());
                }

            }
        }


    }
}