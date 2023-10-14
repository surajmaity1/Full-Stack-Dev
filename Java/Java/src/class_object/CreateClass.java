package class_object;

import java.io.*;

class Test implements Cloneable, Serializable {
    // Your class code here

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class CreateClass {
    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            CloneNotSupportedException {

        // Ways to Create an Object of a Class

        // 1. Using new keyword
        Test obj1 = new Test();


        // 2. Using Class.forName(String className) method
        Test obj2 = (Test) Class
                .forName("class_object.Test")
                .newInstance();

        // 3. Using clone() method
        Test obj3 = new Test();
        Test obj4 = (Test) obj3.clone();


        // 4. Deserialization

        Test objToDeserialize;

        try (FileInputStream fileIn = new FileInputStream("object.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            objToDeserialize = (Test) in.readObject();
            System.out.println("Object deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //System.out.println(objToDeserialize);


    }
}
