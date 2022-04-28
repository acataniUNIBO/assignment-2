class Truck extends Car {    
    int cargos;

    Truck(int cargos, int wheels, String model, String tuMamma) {
        super(wheels, model, tuMamma);
        this.cargos = cargos;
    }
}