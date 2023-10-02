package customAnnotations;

@CustomAnnotationOne
public class Vehicle {

    @CustomAnnotationThree
    String model;

    double speed;

    public Vehicle(String model) {this.model = model;};

    @CustomAnnotationTwo(times = 5)
    public void changeGear() {
        System.out.println("Gear Changed");
    }
    public void changeIndicator() {
        System.out.println("Indicator signal Changed");
    }
}
