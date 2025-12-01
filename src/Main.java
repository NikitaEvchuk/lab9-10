//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Exceptioncreator generator = new Exceptioncreator();

        try {
            System.out.println("Attempting to run the method...");
            generator.createException();

        } catch (NullPointerException e) {

            System.out.println("\n--- CAUGHT EXCEPTION ---");

            System.out.println("\n--- STACK TRACE ---");
            e.printStackTrace();

            System.out.println("\n--- TO STRING ---");
            System.out.println(e.toString());
        }
    }
}
