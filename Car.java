class Car {
    int wheels;
    String model;

    Car(int wheels, String model) {
        this.wheels = wheels;
        this.model = model;
    }

    public int getNumberOfWheels() {
        return this.wheels;
    }

    public void setNumberOfWheels(int wheels) {
        this.wheels = wheels;
    }
}