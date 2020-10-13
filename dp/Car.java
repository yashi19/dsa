public class Car extends Vehicle{
    int basePrice = 3;

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.calculateFair(3));
    }

}