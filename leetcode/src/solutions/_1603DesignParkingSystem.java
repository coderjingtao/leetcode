package solutions;

/**
 * NO.1603 Design Parking System
 * Keywords:
 * Difficulty: Easy
 * Company: Amazon
 */
public class _1603DesignParkingSystem {
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(0,0,2);
        boolean one = parkingSystem.addCar(1);
        System.out.println("one = " + one);
        boolean two = parkingSystem.addCar(2);
        System.out.println("two = " + two);
        boolean three = parkingSystem.addCar(3);
        System.out.println("three = " + three);
    }


}

class ParkingSystem {

    private int big;
    private int medium;
    private int small;
    private int callLimit = 1000;

    public ParkingSystem(int big, int medium, int small) {
        if(big < 0 || big > 1000 || medium < 0 || medium > 1000 || small < 0 || small > 1000){
            throw new IllegalArgumentException();
        }
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if(callLimit <= 0){
            return false;
        }
        callLimit--;
        switch (carType){
            case 1:
                big--;
                if(big < 0) return false;
                break;
            case 2:
                medium--;
                if(medium < 0) return false;
                break;
            case 3:
                small--;
                if(small < 0) return false;
                break;
            default:
                throw new IllegalArgumentException(carType +" is not in the car type scope");
        }
        return true;
    }
}
