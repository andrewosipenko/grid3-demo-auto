package grid3.demo.auto


class Car {
    Brand brand
    CarModel model
    String carId

    Engine engine
    Transmission transmission

    static constraints = {
        carId unique: ['brand'], blank: false
    }
}
