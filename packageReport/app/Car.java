package kebab;

class Car {
    int wheels;
    String model;
    String tuMamma;

    Car(int wheels, String model, String tuMamma) {
        this.wheels = wheels;
        this.model = model;
        this.tuMamma = tuMamma;
    }

    public int getNumberOfWheels() {
        return this.wheels;
    }

    public void setNumberOfWheels(int wheels) {
        this.wheels = wheels;
    }
}

class Truck extends Car {    
    int cargos;

    Truck(int cargos, int wheels, String model, String tuMamma) {
        super(wheels, model, tuMamma);
        this.cargos = cargos;
    }
}

interface ApeCar { 
    public boolean apeHasStereo();
}