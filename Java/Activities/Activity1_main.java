public class Activity1_main {

    public static void main(String[] args) {
        Activity1_car toyota = new Activity1_car();
        toyota.make = 2014;
        toyota.color = "Black";
        toyota.transmission = "Manual";
    
        //Using Car class method
        toyota.displayCharacterstics();
        toyota.accelerate();
        toyota.brake();
    }

}