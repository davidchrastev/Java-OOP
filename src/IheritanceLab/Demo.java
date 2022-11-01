package IheritanceLab;

public class Demo {
    public static class Vehicle {
        private double speed;

        void stop() {
            speed = 0;
        }

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }
    }
    public static class Car extends Vehicle {
        boolean parkingBrakeOn;


    }
    public static class Airplane extends Vehicle {
        double altitude;

    }
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setSpeed(212);
        Vehicle object = new Airplane();
        object.setSpeed(1212);
        System.out.println(object.getSpeed());


    }
}
