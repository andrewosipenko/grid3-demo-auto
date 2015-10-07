package grid3.demo.auto


class Car {
    CarModel model
    String carId

    Engine engine
    Transmission transmission

    static constraints = {
        carId unique: ['model'], blank: false
    }
}
