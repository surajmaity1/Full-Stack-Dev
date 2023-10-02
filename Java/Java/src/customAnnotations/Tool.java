package customAnnotations;

public class Tool {
    String name;
    double wh;

    public Tool(String name) {this.name = name;};
    public void modifyStructure() {
        System.out.println("Structure modified");
    }
    public void apply() {
        System.out.println("Tool applied");
    }
}
